package cn.com.chinahitech.bjmarket.exam.DTO;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class TestPaperWithBank {
    private Integer paperId;             // 试卷ID
    private String title;                // 试卷标题
    private String description;          // 试卷描述（来自 test_paper）

    private Integer qBankId;             // 题库ID
    private String qBankName;            // 题库名称
    private String qBankDescription;     // 题库描述（来自 question_bank）
    private String qBankCategory;        // 题库分类（来自 question_bank）
}
