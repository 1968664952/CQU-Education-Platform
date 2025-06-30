package cn.com.chinahitech.bjmarket.course.Mapper;

import cn.com.chinahitech.bjmarket.course.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CourseMapper {
    @Select("SELECT * FROM course WHERE course_id = #{courseId}")
    Course findByCourseId(String courseId);
}
