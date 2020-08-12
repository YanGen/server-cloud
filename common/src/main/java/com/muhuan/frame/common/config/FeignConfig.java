package com.muhuan.frame.common.config;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName FeignConfig
 * @Description TODO
 * @Author geng <yg.db@uniteddata.com>
 * @Date 2020/8/12
 * @Version 1.0.0
 **/
@Configuration
public class FeignConfig {
    /**
     * 配置日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
