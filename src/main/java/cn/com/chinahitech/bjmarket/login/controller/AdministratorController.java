package cn.com.chinahitech.bjmarket.login.controller;

import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import cn.com.chinahitech.bjmarket.login.DTO.AdminLoginDTO;
import cn.com.chinahitech.bjmarket.login.Mapper.AdministratorMapper;
import cn.com.chinahitech.bjmarket.login.Service.AdministratorService;
import cn.com.chinahitech.bjmarket.login.Service.DailyVisitsService;
import cn.com.chinahitech.bjmarket.login.entity.DailyVisits;
import cn.com.chinahitech.bjmarket.login.entity.Student;
import cn.com.chinahitech.bjmarket.utils.JwtUtils;
import com.alibaba.fastjson.JSON;
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
    @Autowired
    private DailyVisitsService dailyVisitsService;

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

    @GetMapping("/getDailyVisit")
    public String getDailyVisit() {
        List<DailyVisits> dailyVisits = null;
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            dailyVisits = dailyVisitsService.getDailyVisit();
            if (dailyVisits != null) {
                result.put("status", "200");
                result.put("msg", "检索成功！");
                result.put("data", dailyVisits);
            } else {
                result.put("status", "500");
                result.put("msg", "没有访问记录");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result.put("status", "501");
            result.put("msg", "异常：" + ex.getMessage());
        }
        return JSON.toJSONString(result);
    }
}
