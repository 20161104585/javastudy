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
        return "Hello, Spring Clould";
    }


}
