package cn.com.chinahitech.bjmarket.exam.Entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class WrongCollection {
    private Integer collectionId;
    private String category;
    private String studentId;
    private Integer questionId;
    private Integer paperId;
    private Timestamp createTime;
}
