package cn.com.chinahitech.bjmarket.exam.Mapper;

import cn.com.chinahitech.bjmarket.exam.DTO.WrongQuestionRef;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WrongCollectionMapper {

    @Select("SELECT paper_id, question_id, category FROM wrong_collection WHERE student_id = #{studentId}")
    List<WrongQuestionRef> getWrongQuestionRefsByStudentId(@Param("studentId") Integer studentId);
}
