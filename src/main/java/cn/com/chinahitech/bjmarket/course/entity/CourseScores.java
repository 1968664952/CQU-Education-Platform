package cn.com.chinahitech.bjmarket.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class CourseScores {
    @TableId(value = "score_id", type = IdType.AUTO)
    Integer scoreId;
    String studentId;
    String courseName;
    Integer courseScore;
    Integer courseCredit;
    String category;
}
