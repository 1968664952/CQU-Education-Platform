package cn.com.chinahitech.bjmarket.exam.Mapper;

import cn.com.chinahitech.bjmarket.exam.Entity.QuestionShortAnswer;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionTF;
import org.apache.ibatis.annotations.*;

@Mapper
public interface QuestionShortAnswerMapper {
    @Select("SELECT * FROM question_short_answer WHERE paper_id = #{paperId} AND question_id = #{questionId}")
    QuestionShortAnswer getQuestion(@Param("paperId") Integer paperId, @Param("questionId") Integer questionId);
    @Insert("INSERT INTO question_short_answer (paper_id, question_type, content, answer, difficulty, created_at, `order`) " +
            "VALUES(#{paperId}, #{questionType}, #{content}, #{answer}, #{difficulty},  #{createdAt}, #{order})")
    int insert(QuestionShortAnswer question);

    @Delete("DELETE FROM question_short_answer  WHERE question_id = #{questionId}")
    int deleteById(@Param("questionId") Integer questionId);
}
