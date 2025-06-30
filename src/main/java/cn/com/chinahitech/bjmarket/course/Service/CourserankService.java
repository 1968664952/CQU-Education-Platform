package cn.com.chinahitech.bjmarket.course.Service;

import cn.com.chinahitech.bjmarket.course.Mapper.CourseMapper;
import cn.com.chinahitech.bjmarket.course.Mapper.CourserankMapper;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class CourserankService {

    @Autowired
    private CourserankMapper courseMapper;

    public List<Course> getTopCoursesByCourseBankId(Integer cBankId, int limit) {
        return courseMapper.findCoursesByBankId(cBankId, limit);
    }
}
