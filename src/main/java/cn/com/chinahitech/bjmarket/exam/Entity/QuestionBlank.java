package cn.com.chinahitech.bjmarket.exam.Entity;


import lombok.Data;
import java.sql.Timestamp;

@Data
public class QuestionBlank {

    /** 题目ID */
    private Integer questionId;

    /** 所属试卷ID */
    private Integer paperId;

    /** 题目类型 */
    private String questionType;

    /** 题目内容 */
    private String content;

    /** 难度（可为 1~5 等整数等级） */
    private Integer difficulty;

    /** 题目解析 */
    private String explanation;

    /** 正确答案 */
    private String answer;

    /** 创建时间 */
    private Timestamp createdAt;

    /** 题目在试卷中的序号 */
    private Integer order;
}
