package cn.com.chinahitech.bjmarket.course.Mapper;

import cn.com.chinahitech.bjmarket.course.entity.CourseKu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CourseKuMapper {
    @Select("SELECT * FROM course_ku WHERE c_bank_id = #{cBankId}")
    CourseKu findByCourseKuId(String cBankId);
}
