package cn.com.chinahitech.bjmarket.login.Service;


import cn.com.chinahitech.bjmarket.login.entity.Administrator;
import cn.com.chinahitech.bjmarket.login.entity.Student;

import java.util.List;

public interface AdministratorService {
    Administrator findById(Integer administratorId);
    boolean verifyPassword(Integer administratorId, String plainPassword);
    List<Student> findAll();
}
