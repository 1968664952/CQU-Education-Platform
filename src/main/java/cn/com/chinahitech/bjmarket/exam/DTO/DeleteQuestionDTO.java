package cn.com.chinahitech.bjmarket.exam.DTO;

import lombok.Data;

@Data
public class DeleteQuestionDTO {
    private Integer questionId;
    private String type; // tf, select, blank, shortAnswer
}
