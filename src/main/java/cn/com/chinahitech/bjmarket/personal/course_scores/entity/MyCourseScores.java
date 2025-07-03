package cn.com.chinahitech.bjmarket.personal.course_scores.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class MyCourseScores {
    @TableId(value = "score_id", type = IdType.AUTO)
    Integer scoreId;
    String studentId;
    String courseName;
    Integer courseScore;
    Integer courseCredit;
    String category;
}
