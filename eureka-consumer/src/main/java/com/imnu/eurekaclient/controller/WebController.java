package com.imnu.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

/**
 * @Description:
 * @Author: haole
 * @Date: 2021/1/12 11:18
 */
@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/web/hello")
    public String hello() {
        return restTemplate.getForEntity("http://EUREKA-CLIENT-01/service/hello",String.class).getBody();
    }


}
