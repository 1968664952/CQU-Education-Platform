package cn.com.chinahitech.bjmarket.controller;
import cn.com.chinahitech.bjmarket.Service.StudentService;
import cn.com.chinahitech.bjmarket.entity.Student;
import cn.com.chinahitech.bjmarket.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String studentId,
                                   @RequestParam String password) {
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

            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
