package cn.com.chinahitech.bjmarket.exam.Mapper;

import cn.com.chinahitech.bjmarket.exam.DTO.WrongQuestionRef;
import cn.com.chinahitech.bjmarket.exam.Entity.WrongCollection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WrongCollectionMapper {

    @Select("SELECT paper_id, question_id, category,create_time FROM wrong_collection WHERE student_id = #{studentId}")
    List<WrongQuestionRef> getWrongQuestionRefsByStudentId(@Param("studentId") Integer studentId);
    @Select("SELECT COUNT(*) FROM wrong_collection WHERE category = #{category} AND question_id = #{questionId} AND paper_id = #{paperId}")
    int countSameWrong(@Param("category") String category,
                       @Param("questionId") int questionId,
                       @Param("paperId") int paperId);

    @Insert("INSERT INTO wrong_collection(category, student_id, question_id, paper_id,create_time) " +
            "VALUES(#{category}, #{studentId}, #{questionId}, #{paperId}, #{createTime})")
    int insertWrong(WrongCollection wrong);
}
