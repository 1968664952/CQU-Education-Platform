package cn.com.chinahitech.bjmarket.exam.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class WrongCollectionDTO {
    private String category;
    private String studentId;
    private Integer questionId;
    private Integer paperId;
    private Timestamp createTime;
}
