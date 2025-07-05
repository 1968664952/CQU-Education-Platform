package cn.com.chinahitech.bjmarket.course.Mapper;


import cn.com.chinahitech.bjmarket.course.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface CourseManagementMapper extends BaseMapper<Course> {

    @Insert("INSERT INTO course (c_bank_id, course_name, course_code, title, instructor, category, cover_url, description, difficulty, total_play_count, favorite_count, composite_score, grade) " +
            "VALUES (#{cBankId}, #{courseName}, #{courseCode}, #{title}, #{instructor}, #{category}, #{coverUrl}, #{description}, #{difficulty}, #{totalPlayCount}, #{favoriteCount}, #{compositeScore}, #{grade})")
    int insertCourse(Course course);


    @Delete("DELETE FROM course WHERE course_id=#{course_id}")
    int deleteCourse(Integer course_id);
}
