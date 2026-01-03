package cn.com.chinahitech.bjmarket.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Setter;

import java.sql.Timestamp;

@Data
public class Course {
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;
    private Integer cBankId;           // 课程库ID
    private String courseName;         // 课程名称
    private String courseCode;         // 课程代码
    private String title;              // 课程标题
    private String instructor;         // 课程讲师
    private String category;           // 课程类别
    private String coverUrl;           // 封面图URL
    private String description;        // 课程描述
    private Integer difficulty;        // 难度级别（1-5，1最简单）
    private String createdAt;       // 创建时间
    private String updatedAt;       // 更新时间
    private Long totalPlayCount;       // 总播放量
    private Integer favoriteCount;     // 收藏数
    private Float compositeScore;      // 综合得分
    private Integer grade;
}