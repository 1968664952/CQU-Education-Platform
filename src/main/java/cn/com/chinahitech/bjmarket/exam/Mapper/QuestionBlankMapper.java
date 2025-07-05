package cn.com.chinahitech.bjmarket.exam.Mapper;

import cn.com.chinahitech.bjmarket.exam.Entity.QuestionBlank;
import org.apache.ibatis.annotations.*;

@Mapper
public interface QuestionBlankMapper {
    @Select("SELECT * FROM question_blank WHERE paper_id = #{paperId} AND question_id = #{questionId}")
    QuestionBlank getQuestion(@Param("paperId") Integer paperId, @Param("questionId") Integer questionId);
    @Insert("INSERT INTO question_blank(paper_id, question_type, content, answer, difficulty, explanation, created_at, `order`) " +
            "VALUES(#{paperId}, #{questionType}, #{content}, #{answer}, #{difficulty}, #{explanation}, #{createdAt}, #{order})")
    int insert(QuestionBlank question);

    @Delete("DELETE FROM question_blank WHERE question_id = #{questionId}")
    int deleteById(@Param("questionId") Integer questionId);
}
