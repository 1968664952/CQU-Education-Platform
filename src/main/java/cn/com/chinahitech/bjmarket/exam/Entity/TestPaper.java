package cn.com.chinahitech.bjmarket.exam.Entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class TestPaper {

    /** 试卷ID */
    private Integer paperId;

    /** 题库ID */
    private Integer qBankId;

    /** 试卷名称 */
    private String title;

    /** 试卷描述 */
    private String description;

    /** 创建时间 */
    private Timestamp createdAt;

    /** 试卷题型分类：选择、判断、填空、简答 */
    private String category;
}