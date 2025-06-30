package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Mapper.CourseMapper;
import cn.com.chinahitech.bjmarket.course.Service.CourseService;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> queryCourseByKeyword(String Keyword){
        List<Course> courseList=null;
        QueryWrapper<Course> wrapper=new QueryWrapper<Course>();

        wrapper.like("course_name",Keyword);

        courseList=courseMapper.selectList(wrapper);

        return courseList;
    }
}
