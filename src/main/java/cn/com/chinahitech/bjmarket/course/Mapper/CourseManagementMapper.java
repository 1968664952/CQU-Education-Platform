package cn.com.chinahitech.bjmarket.course.Mapper;


import cn.com.chinahitech.bjmarket.course.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface CourseManagementMapper {

    @Insert("INSERT INTO course (c_bank_id, course_name, course_code, title, instructor, category, cover_url, description, difficulty, created_at, updated_at, total_play_count, favorite_count, composite_score) " +
            "VALUES (#{cBankId}, #{courseName}, #{courseCode}, #{title}, #{instructor}, #{category}, #{coverUrl}, #{description}, #{difficulty}, #{createdAt}, #{updatedAt}, #{totalPlayCount}, #{favoriteCount}, #{compositeScore})")
    int insertCourse(Course course);


    @Delete("DELETE FROM course WHERE course_id=#{course_id}")
    int deleteCourse(Integer course_id);
}
