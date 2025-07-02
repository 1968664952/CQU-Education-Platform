package cn.com.chinahitech.bjmarket.exam.Entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class QuestionTF {

    /** 题目ID */
    private Integer questionId;

    /** 试卷ID */
    private Integer paperId;

    /** 题目类型 */
    private String questionType;

    /** 题目内容 */
    private String content;

    /** 难度等级 */
    private Integer difficulty;

    /** 题目解析 */
    private String explanation;

    /** 正确答案（T/F） */
    private String answer;

    /** 创建时间 */
    private Timestamp createdAt;

    /** 试卷中的题号 */
    private Integer questionOrder;
}
