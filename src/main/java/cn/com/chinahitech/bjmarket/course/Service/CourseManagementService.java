package cn.com.chinahitech.bjmarket.course.Service;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import cn.com.chinahitech.bjmarket.course.entity.DailyCourseUpload;

import java.util.List;

public interface CourseManagementService {
    int addCourse(Course course);

    int deleteCourse(Integer cBankId);

}
