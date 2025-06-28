package cn.com.chinahitech.bjmarket.login.Service;

import cn.com.chinahitech.bjmarket.login.entity.Student;

public interface StudentService {
    Student login(String studentId, String password) throws Exception;
}
