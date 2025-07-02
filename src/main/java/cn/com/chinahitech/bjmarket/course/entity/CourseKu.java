package cn.com.chinahitech.bjmarket.course.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseKu {
    private Integer cBankId;
    private String cBankName;
    private String description;
    private String category;
    private LocalDateTime createdAt;
}
