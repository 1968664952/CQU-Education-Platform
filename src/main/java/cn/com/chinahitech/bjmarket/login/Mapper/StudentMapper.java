package cn.com.chinahitech.bjmarket.login.Mapper;

import cn.com.chinahitech.bjmarket.login.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM students WHERE student_id = #{studentId}")
    Student findByStudentId(String studentId);
}
