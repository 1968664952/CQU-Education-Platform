package cn.com.chinahitech.bjmarket.course.Service;
import cn.com.chinahitech.bjmarket.course.entity.Course;

public interface CourseManagementService {
    int addCourse(Course course);

    int deleteCourse(Integer cBankId);
}
