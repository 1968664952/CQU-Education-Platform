package cn.com.chinahitech.bjmarket.exam.Mapper;

import cn.com.chinahitech.bjmarket.exam.Entity.QuestionSelect;
import org.apache.ibatis.annotations.*;

@Mapper
public interface QuestionSelectMapper {
    @Select("SELECT * FROM question_select WHERE paper_id = #{paperId} AND question_id = #{questionId}")
    QuestionSelect getQuestion(@Param("paperId") Integer paperId, @Param("questionId") Integer questionId);
    @Insert("INSERT INTO question_select(paper_id, question_type, content, option_a, option_b, option_c, option_d, answer, difficulty, explanation,created_at,question_order) " +
            "VALUES(#{paperId}, #{questionType}, #{content}, #{optionA}, #{optionB}, #{optionC}, #{optionD}, #{answer}, #{difficulty}, #{explanation},#{createdAt},#{questionOrder})")
    int insert(QuestionSelect question);

    @Delete("DELETE FROM question_select WHERE question_id = #{questionId}")
    int deleteById(@Param("questionId") Integer questionId);
}
