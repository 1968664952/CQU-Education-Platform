package cn.com.chinahitech.bjmarket.controller;
import cn.com.chinahitech.bjmarket.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class AuthController {


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 假设用户名密码校验成功（实际应查数据库）
        if ("admin".equals(username) && "123456".equals(password)) {
            return JwtUtil.generateToken(username); // 返回 token 给前端
        }
        return "Login failed";
    }
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        String user = (String) request.getAttribute("username");
        return "Hello, " + user;
    }
}
