package cn.com.chinahitech.bjmarket.exam.Mapper;

import cn.com.chinahitech.bjmarket.exam.Entity.QuestionTF;
import org.apache.ibatis.annotations.*;

@Mapper
public interface QuestionTFMapper {
    @Select("SELECT * FROM question_tf WHERE paper_id = #{paperId} AND question_id = #{questionId}")
    QuestionTF getQuestion(@Param("paperId") Integer paperId, @Param("questionId") Integer questionId);
    @Insert("INSERT INTO question_tf(paper_id, question_type, content, answer, difficulty, explanation, created_at, `order`) " +
            "VALUES(#{paperId}, #{questionType}, #{content}, #{answer}, #{difficulty}, #{explanation}, #{createdAt}, #{questionOrder})")
    int insert(QuestionTF question);

    @Delete("DELETE FROM question_tf WHERE question_id = #{questionId}")
    int deleteById(@Param("questionId") Integer questionId);
}
