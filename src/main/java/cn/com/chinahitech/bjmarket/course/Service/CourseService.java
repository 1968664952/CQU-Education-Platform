package cn.com.chinahitech.bjmarket.course.Service;

import cn.com.chinahitech.bjmarket.course.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> queryCourseByKeyword(String Keyword);
}
