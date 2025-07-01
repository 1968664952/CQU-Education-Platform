package cn.com.chinahitech.bjmarket.login.controller;
import cn.com.chinahitech.bjmarket.login.DTO.LoginRequest;
import cn.com.chinahitech.bjmarket.login.Service.StudentService;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.login.entity.Student;
import cn.com.chinahitech.bjmarket.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public Result<?> login(HttpServletRequest request,
                           @RequestBody LoginRequest loginRequest) {
        String studentId = loginRequest.getStudentId();
        String password = loginRequest.getPassword();

        try {
            Student student = studentService.login(studentId, password);
            String token = JwtUtil.generateToken(student.getStudentId());

            Map<String, Object> data = new HashMap<>();
            data.put("token", token);
            data.put("realName", student.getRealName());
            data.put("avatarUrl", student.getAvatarUrl());
            data.put("enrollmentYear", student.getEnrollmentYear());
            data.put("grade", student.getGrade());
            data.put("majorName", student.getMajorName());
            data.put("studentId", student.getStudentId());
            //第一步：获取session
            HttpSession session = request.getSession();
            //第二步：将想要保存到数据存入session中
            session.setAttribute("studentId",studentId);
            session.setAttribute("majorName",student.getMajorName());
            //这样就完成了用户名和密码保存到session的操作


            return Result.success(data);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    @RequestMapping(value="/sayHi")
    public String sayHi(){
        return "Hello World!";
    }
}

