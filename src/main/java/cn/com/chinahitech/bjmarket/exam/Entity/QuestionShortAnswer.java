package cn.com.chinahitech.bjmarket.exam.Entity;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class QuestionShortAnswer {

    /** 题目ID */
    private Integer questionId;

    /** 所属试卷ID */
    private Integer paperId;

    /** 题目类型（例如：简答题） */
    private String questionType;

    /** 题目内容 */
    private String content;

    /** 难度等级 */
    private Integer difficulty;

    /** 答案解析 */
    private String answer;

    /** 创建时间 */
    private Timestamp createdAt;

    /** 试卷中的题目序号 */
    private Integer order;
}
