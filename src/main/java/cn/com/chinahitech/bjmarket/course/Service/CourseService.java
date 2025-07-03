package cn.com.chinahitech.bjmarket.course.Service;

import cn.com.chinahitech.bjmarket.course.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> queryCourseByKeyword(String Keyword);
    List<Course> personalRecom1(List<String> courseName,int cBankId, int grade);
    List<Course> personalRecom2(int cBankId, int grade);
    List<Course> personalRecom3(int cBankId);
    List<Course> queryPGCourse();
    int addFavoriteCount(String courseId);
    int delFavoriteCount(String courseId);
}
