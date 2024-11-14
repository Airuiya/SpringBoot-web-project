package com.itheima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Gumt
 * @CreateTime: 2024-11-14
 * @Description: 浏览器发起请求/test后，给浏览器返回字符串“Hello World!”
 * @Version: 1.0
 */
//请求处理类
@RestController
public class HelloController {
    @RequestMapping("/test")
    public String Hello() {
        System.out.println("Hello World~");
        return "Hello World~";
    }
}
