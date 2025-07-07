package cn.com.chinahitech.bjmarket.exam.Entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class WrongQuestionDetail {
    private Integer studentId;
    private Integer paperId;
    private Integer questionId;
    private String category;
    private Timestamp createTime;

    private String paperTitle;
    private String qBankName;
    private String qBankCategory;
    private String qBankDescription;

    // Getter 和 Setter 省略...
}
