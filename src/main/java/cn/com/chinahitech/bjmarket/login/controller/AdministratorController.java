package cn.com.chinahitech.bjmarket.login.controller;

import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.login.DTO.AdminLoginDTO;
import cn.com.chinahitech.bjmarket.login.Mapper.AdministratorMapper;
import cn.com.chinahitech.bjmarket.login.Service.AdministratorService;
import cn.com.chinahitech.bjmarket.login.entity.Student;
import cn.com.chinahitech.bjmarket.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody AdminLoginDTO dto) {
        boolean valid = administratorService.verifyPassword(dto.getAdministratorId(), dto.getPassword());
        if (!valid) {
            throw new RuntimeException("管理员ID或密码错误");
        }

        String token = JwtUtils.generateToken("admin_" + dto.getAdministratorId(), "admin");
        return Result.success(Map.of("token", token));
    }

    @GetMapping("/allstudents")
    public Result<List<Student>> getallstudents() {

        return Result.success(administratorService.findAll());
    }
}
