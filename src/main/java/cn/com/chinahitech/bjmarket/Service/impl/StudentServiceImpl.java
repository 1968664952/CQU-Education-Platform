package cn.com.chinahitech.bjmarket.Service.impl;

import cn.com.chinahitech.bjmarket.Mapper.StudentMapper;
import cn.com.chinahitech.bjmarket.Service.StudentService;
import cn.com.chinahitech.bjmarket.entity.Student;
import cn.com.chinahitech.bjmarket.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override

    public Student login(String studentId, String password) throws Exception {
        Student student = studentMapper.findByStudentId(studentId);

        if (student == null) {
            throw new Exception("账号不存在");
        }

        // 对明文密码进行 SHA-256 加密
        String hashedPassword = HashUtil.sha256(password);

        // 与数据库中的 password_hash 进行比对
        if (!student.getPasswordHash().equalsIgnoreCase(hashedPassword)) {
            throw new Exception("密码错误");
        }

        return student;
    }

}
