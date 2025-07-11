package cn.com.chinahitech.bjmarket.course.Mapper;


import java.util.List;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CourserankMapper {

    @Select("SELECT * FROM course WHERE c_bank_id = #{cBankId} ORDER BY total_play_count desc limit 5 ")
    List<Course> findCoursesByBankId(@Param("cBankId") Integer cBankId);
}