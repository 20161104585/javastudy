package com.imnu.eurekaclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: haole
 * @Date: 2021/1/12 11:18
 */
@RestController
public class HelloController {
    @RequestMapping("/service/hello")
    public String hello() {
        System.out.println("这是服务提供者02！！！！！！！！！！！！！！！！");
        return "Hello, Spring Clould,Client 02!";
    }


}
