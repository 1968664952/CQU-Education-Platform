package cn.com.chinahitech.bjmarket.Service;

import cn.com.chinahitech.bjmarket.entity.Student;

public interface StudentService {
    Student login(String studentId, String password) throws Exception;
}
