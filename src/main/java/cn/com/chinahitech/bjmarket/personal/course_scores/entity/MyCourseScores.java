package cn.com.chinahitech.bjmarket.personal.course_scores.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生选课得分表
 * </p>
 *
 * @author zhufu
 * @since 2025-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course_scores")
public class MyCourseScores implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 得分ID
     */
    @TableId(value = "score_id", type = IdType.AUTO)
    private Integer scoreId;

    /**
     * 学生学号
     */
    private String studentId;

    /**
     * 选课名称
     */
    private String courseName;

    /**
     * 选课得分
     */
    private Integer courseScore;

    /**
     * 选课学分
     */
    private Integer courseCredit;

    /**
     * 选课类别
     */
    private String category;


}
