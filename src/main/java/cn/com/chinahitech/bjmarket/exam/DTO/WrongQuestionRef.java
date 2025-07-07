package cn.com.chinahitech.bjmarket.exam.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class WrongQuestionRef {
    private Integer paperId;
    private Integer questionId;
    private String category;
    private Timestamp createTime;// "选择"、"判断"、"填空"、"简答"
}
