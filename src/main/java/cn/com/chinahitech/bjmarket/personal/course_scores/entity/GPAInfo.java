package cn.com.chinahitech.bjmarket.personal.course_scores.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GPAInfo {
    public String studentId;
    public double gpa;             // 平均绩点
}
