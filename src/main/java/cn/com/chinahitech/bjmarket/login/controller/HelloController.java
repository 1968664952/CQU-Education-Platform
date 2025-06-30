package cn.com.chinahitech.bjmarket.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    @Autowired
    HttpServletRequest request; //通过注解获取一个request

    @RequestMapping(value="/getId")
    public String getId() {
        //通过request来获取保存在session中的用户名
        String studentId = (String) request.getSession().getAttribute("studentId");
        System.out.println(studentId);
        return studentId;
    }
}
//  http://localhost:8081/sayHi