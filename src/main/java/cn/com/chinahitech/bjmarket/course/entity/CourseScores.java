package cn.com.chinahitech.bjmarket.course.entity;

import lombok.Data;

@Data
public class CourseScores {
    Integer scoreId;
    String studentId;
    String courseName;
    Integer courseScore;
    Integer courseCredit;
    String category;
}
