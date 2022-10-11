package com.qwgstudy.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        String path = request.getURI().getPath();
        System.out.println(path);
        HttpHeaders headers = request.getHeaders();
        System.out.println(headers);
        String methodName = request.getMethod().name();
        System.out.println(methodName);
        String hostName = request.getRemoteAddress().getHostName();
        System.out.println(hostName);

        ServerHttpResponse response = exchange.getResponse();
// 用了微服务 肯定是前后端分离的 前后端分离 一般前后通过 json
        // {"code":200,"msg":"ok"}
        // 设置编码 响应头里面置
//        response.getHeaders().set("content-type","application/json;charset=utf-8");
//        // 组装业务返回值
//        HashMap<String, Object> map = new HashMap<>(4);
//        map.put("code", HttpStatus.UNAUTHORIZED.value());
//        map.put("msg","你未授权");
//        ObjectMapper objectMapper = new ObjectMapper();
//        // 把一个map转成一个字节
//        byte[] bytes = new byte[0];
//        try {
//            bytes = objectMapper.writeValueAsBytes(map);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        // 通过buffer工厂将字节数组包装成 一个数据包
//        DataBuffer wrap = response.bufferFactory().wrap(bytes);
//        return response.writeWith(Mono.just(wrap));
        // 放行 到下一个过滤器了
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
