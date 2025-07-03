package cn.com.chinahitech.bjmarket.exam.DTO;

import lombok.Data;

@Data
public class WrongQuestionRef {
    private Integer paperId;
    private Integer questionId;
    private String category; // "选择"、"判断"、"填空"、"简答"
}
