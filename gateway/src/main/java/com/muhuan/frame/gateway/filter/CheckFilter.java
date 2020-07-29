package com.muhuan.frame.gateway.filter;


import com.alibaba.fastjson.JSON;
import com.muhuan.frame.common.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class CheckFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        HttpHeaders headers = request.getHeaders();
        URI requestUri = request.getURI();
        String path = requestUri.getPath();//路径
        String token = headers.get("token") == null  && headers.size() > 0 ? "" : headers.get("token").get(0);

//        // 此处写过滤逻辑 根据上边提供的请求头和请求方法
//        if (false) {
//            DataBuffer buffer = error(response, -1);
//            return response.writeWith(Mono.just(buffer));
//        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }


}
