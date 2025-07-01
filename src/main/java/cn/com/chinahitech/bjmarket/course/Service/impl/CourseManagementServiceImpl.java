package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Mapper.CourseManagementMapper;
import cn.com.chinahitech.bjmarket.course.Service.CourseManagementService;
import cn.com.chinahitech.bjmarket.course.entity.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class CourseManagementServiceImpl implements CourseManagementService {
    @Autowired
    private CourseManagementMapper courseManagementMapper;

    @Override
    public int addCourse(Course course) {
        course.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        course.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return courseManagementMapper.insertCourse(course);
    }

    @Override
    public int deleteCourse(Integer courseId) {
        return courseManagementMapper.deleteCourse(courseId);
    }
}
