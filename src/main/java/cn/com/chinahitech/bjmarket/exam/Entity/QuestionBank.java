package cn.com.chinahitech.bjmarket.exam.Entity;



import lombok.Data;
import java.sql.Timestamp;

@Data
public class QuestionBank {

    /** 题库ID */
    private Integer qBankId;

    /** 题库名称 */
    private String qBankName;

    /** 题库描述 */
    private String description;

    /** 题库分类 */
    private String category;

    /** 封面图URL */
    private String coverImage;

    /** 创建时间 */
    private Timestamp createdAt;
}
