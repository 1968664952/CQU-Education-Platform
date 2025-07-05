package cn.com.chinahitech.bjmarket.login.Mapper;

import cn.com.chinahitech.bjmarket.login.entity.Administrator;
import cn.com.chinahitech.bjmarket.login.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdministratorMapper {

    @Select("SELECT * FROM administrator WHERE administrator_id = #{administratorId}")
    Administrator findById(Integer administratorId);
    @Select("SELECT * FROM students")
    List<Student> findAll();
}
