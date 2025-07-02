package cn.com.chinahitech.bjmarket.exam.Mapper;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionBlank;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionSelect;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionShortAnswer;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionTF;
import cn.com.chinahitech.bjmarket.exam.Service.QuestionBankService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GetQuestionMapper {

    @Select("SELECT * FROM question_blank WHERE paper_id = #{paperId}")
    List<QuestionBlank> getQuestionBlank(Integer paperId);
    @Select("SELECT * FROM question_select WHERE paper_id = #{paperId}")
    List<QuestionSelect> getQuestionSelect(Integer paperId);
    @Select("SELECT * FROM question_short_answer WHERE paper_id = #{paperId}")
    List<QuestionShortAnswer> getQuestionShortAnswer(Integer paperId);
    @Select("SELECT * FROM question_tf WHERE paper_id = #{paperId}")
    List<QuestionTF> getQuestionTF(Integer paperId);
}

