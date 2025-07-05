package cn.com.chinahitech.bjmarket.login.controller;

import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.login.DTO.AdminLoginDTO;
import cn.com.chinahitech.bjmarket.login.Mapper.AdministratorMapper;
import cn.com.chinahitech.bjmarket.login.Service.AdministratorService;
import cn.com.chinahitech.bjmarket.login.entity.Student;
import cn.com.chinahitech.bjmarket.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody AdminLoginDTO dto) {
        try{
            boolean valid = administratorService.verifyPassword(dto.getAdministratorId(), dto.getPassword());
            if (!valid) {
                throw new RuntimeException("管理员ID或密码错误");
            }
            Map<String, Object> data = new HashMap<>();

            String token = JwtUtils.generateToken("admin_" + dto.getAdministratorId(), "admin");
            data.put("token", token);
            return Result.success(data);
        }  catch (Exception e) {
        return Result.error(e.getMessage());
    }
    }

    @GetMapping("/allstudents")
    public Result<List<Student>> getallstudents() {

        return Result.success(administratorService.findAll());
    }
}
