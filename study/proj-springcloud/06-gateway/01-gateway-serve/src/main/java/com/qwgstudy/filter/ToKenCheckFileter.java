package com.qwgstudy.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class ToKenCheckFileter implements GlobalFilter, Ordered {

    @Autowired
    public StringRedisTemplate redisTemplate;

    private static List<String> ALLOW_PATH = Arrays.asList("/login-service/doLogin", "/myUrl","/doLogin");


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
//        获取url
        String path = request.getURI().getPath();
//        判断是否在允许在放行url里面
        if(ALLOW_PATH.contains(path)){
            return chain.filter(exchange);
        }
//        获取请求体存放的token值，一般我们把token存放在请求体的Authorization属性中
        List<String> authorization = request.getHeaders().get("Authorization");

//        token可能有多个，使用集合查看是否为空
        if(!CollectionUtils.isEmpty(authorization)){
            String token = authorization.get(0);
            if(StringUtils.hasText(token)){
//        因为约定有前缀 bearer token 需要把bearer 变为空
                String realtoken = token.replace("bearer ","");
//        获得最后的token值，然后到redisTemplate.hasKey(token),判断是否为空
//        不为空，说明验证正确放行
                if(StringUtils.hasText(realtoken) && redisTemplate.hasKey(realtoken)){
                    return chain.filter(exchange);
                }
            }

        }

//        拦截
//        获取response.getheaders.set()设置响应类型
//        封装map响应信息
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().set("content-type","application/json:charset=utf-8");
        HashMap<String, Object> map = new HashMap<>(4);
        map.put("code",444);
        map.put("msg","你是小黑子，露出小鸡脚了");
//        使用 ObjectMapper objectMapper = new ObjectMapper();将map集合转为byte字节，
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] bytes = new byte[0];
        try {
             bytes = objectMapper.writeValueAsBytes(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//         最后写入流工厂  DataBuffer wrap = response.bufferFactory().wrap(bytes);
//        return response.writeWith(Mono.just(wrap));
        DataBuffer wrap = response.bufferFactory().wrap(bytes);
        return response.writeWith(Mono.just(wrap));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
