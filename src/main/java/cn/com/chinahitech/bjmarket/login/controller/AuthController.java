package cn.com.chinahitech.bjmarket.login.controller;
import cn.com.chinahitech.bjmarket.login.DTO.LoginRequest;
import cn.com.chinahitech.bjmarket.login.Service.DailyVisitsService;
import cn.com.chinahitech.bjmarket.login.Service.StudentService;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.login.entity.Student;
import cn.com.chinahitech.bjmarket.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private StudentService studentService;
    @Autowired
    private DailyVisitsService dailyVisitsService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginRequest loginRequest) {
        String studentId = loginRequest.getStudentId();
        String password = loginRequest.getPassword();

        // Redis 锁定与失败计数键
        String failKey = "login_fail:" + studentId;
        String lockKey = "login_lock:" + studentId;

        // 判断是否已被锁定
        if (Boolean.TRUE.equals(redisTemplate.hasKey(lockKey))) {
            return Result.error("登录失败次数过多，请10分钟后再试");
        }

        try {
            // 尝试登录
            Student student = studentService.login(studentId, password);
            String token = JwtUtils.generateToken(student.getStudentId(), "user");

            // 登录成功，清除失败记录
            redisTemplate.delete(failKey);
            redisTemplate.delete(lockKey);

            // 构建返回数据
            Map<String, Object> data = new HashMap<>();
            data.put("token", token);
            data.put("realName", student.getRealName());
            data.put("avatarUrl", student.getAvatarUrl());
            data.put("enrollmentYear", student.getEnrollmentYear());
            data.put("grade", student.getGrade());
            data.put("majorName", student.getMajorName());
            data.put("studentId", student.getStudentId());

            dailyVisitsService.addDailyVisit();   // 插入每日访问记录

            return Result.success(data);
        } catch (Exception e) {
            // 登录失败，增加失败次数
            Long failCount = redisTemplate.opsForValue().increment(failKey);
            redisTemplate.expire(failKey, Duration.ofMinutes(2)); // 2分钟内有效

            if (failCount >= 5) {
                redisTemplate.opsForValue().set(lockKey, "LOCKED", Duration.ofMinutes(10)); // 锁定10分钟
                return Result.error("失败超过5次，账号已锁定10分钟");
            }

            return Result.error("用户名或密码错误（剩余尝试次数：" + (5 - failCount) + "）");
        }
    }}


