package cn.com.chinahitech.bjmarket.course.Service;

import cn.com.chinahitech.bjmarket.course.entity.CourseScores;

import java.util.List;

public interface CourseScoreService {
    List<CourseScores> queryLearnedCourse(String studentId);
}
