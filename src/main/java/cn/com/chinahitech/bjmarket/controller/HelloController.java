package cn.com.chinahitech.bjmarket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value="/sayHi")
    public String sayHi(){
        return "Hello World!";
    }
}
//  http://localhost:8081/sayHi