package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Mapper.CourseManagementMapper;
import cn.com.chinahitech.bjmarket.course.Service.CourseManagementService;
import cn.com.chinahitech.bjmarket.course.entity.Course;

import cn.com.chinahitech.bjmarket.course.entity.DailyCourseUpload;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseManagementServiceImpl implements CourseManagementService {
    @Autowired
    private CourseManagementMapper courseManagementMapper;

    @Override
    public int addCourse(Course course) {
        return courseManagementMapper.insertCourse(course);
    }

    @Override
    public int deleteCourse(Integer courseId) {
        return courseManagementMapper.deleteCourse(courseId);
    }

    @Override
    public int updateCover(int courseId, String coverUrl) {
        UpdateWrapper<Course> wrapper=new UpdateWrapper<Course>();
        wrapper.eq("course_id",courseId);

        Course course=new Course();
        course.setCoverUrl(coverUrl);

        return courseManagementMapper.update(course,wrapper);
    }


}
