package cn.com.chinahitech.bjmarket.exam.DTO;

import cn.com.chinahitech.bjmarket.exam.Entity.QuestionBlank;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionSelect;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionShortAnswer;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionTF;
import lombok.Data;

import java.util.List;
@Data
public class AllQuestionsResponseDTO {
    private List<QuestionBlank> blank;
    private List<QuestionSelect> select;
    private List<QuestionShortAnswer> shortanswer;
    private List<QuestionTF> tf;

    // Getter 和 Setter
}
