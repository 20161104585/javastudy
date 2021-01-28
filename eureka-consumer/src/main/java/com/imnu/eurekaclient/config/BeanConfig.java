package com.imnu.eurekaclient.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: haole
 * @Date: 2021/1/27 14:52
 */
@Configuration
public class BeanConfig {

    @LoadBalanced //使用Ribbon实现负载均衡的调用
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
