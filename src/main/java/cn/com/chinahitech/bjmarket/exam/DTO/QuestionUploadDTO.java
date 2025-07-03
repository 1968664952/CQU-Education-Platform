package cn.com.chinahitech.bjmarket.exam.DTO;

import cn.com.chinahitech.bjmarket.exam.Entity.QuestionBlank;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionSelect;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionShortAnswer;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionTF;
import lombok.Data;

import java.util.List;

@Data
public class QuestionUploadDTO {
    private List<QuestionTF> tf;
    private List<QuestionSelect> select;
    private List<QuestionBlank> blank;
    private List<QuestionShortAnswer> shortAnswer;
}
