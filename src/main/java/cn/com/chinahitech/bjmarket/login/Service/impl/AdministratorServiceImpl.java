package cn.com.chinahitech.bjmarket.login.Service.impl;

import cn.com.chinahitech.bjmarket.login.Mapper.AdministratorMapper;
import cn.com.chinahitech.bjmarket.login.Service.AdministratorService;
import cn.com.chinahitech.bjmarket.login.entity.Administrator;
import cn.com.chinahitech.bjmarket.login.entity.Student;
import cn.com.chinahitech.bjmarket.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator findById(Integer administratorId) {
        return administratorMapper.findById(administratorId);
    }

    @Override
    public boolean verifyPassword(Integer administratorId, String plainPassword) {
        Administrator admin = administratorMapper.findById(administratorId);
        if (admin == null) return false;
        String hashedPassword = HashUtil.sha256(plainPassword);
        // 真实环境请使用 BCryptPasswordEncoder
        return Objects.equals(admin.getPasswordHash(), hashedPassword); // 简化示例
    }
     public List<Student> findAll(){
        return administratorMapper.findAll();
    };
}
