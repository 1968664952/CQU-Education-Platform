package cn.com.chinahitech.bjmarket.exam.Entity;



import lombok.Data;
import java.sql.Timestamp;

@Data
public class QuestionSelect {

    /** 题目ID */
    private Integer questionId;

    /** 所属试卷ID */
    private Integer paperId;

    /** 题目类型（默认：单选题） */
    private String questionType;

    /** 题目内容 */
    private String content;

    /** 难度等级（1-5） */
    private Integer difficulty;

    /** 题目解析 */
    private String explanation;

    /** 选项A */
    private String optionA;

    /** 选项B */
    private String optionB;

    /** 选项C */
    private String optionC;

    /** 选项D */
    private String optionD;

    /** 正确答案（A/B/C/D） */
    private String answer;

    /** 创建时间 */
    private Timestamp createdAt;

    /** 题目顺序 */
    private Integer questionOrder;
}
