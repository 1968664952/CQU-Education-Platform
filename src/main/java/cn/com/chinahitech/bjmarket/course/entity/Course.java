package cn.com.chinahitech.bjmarket.course.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Course {
    private Long courseId;
    private Long cBankId;
    private String courseName;
    private String courseCode;
    private String title;
    private String instructor;
    private String category;
    private String coverUrl;
    private String description;
    private String difficulty;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer totalPlayCount;
    private Integer favoriteCount;
    private Double compositeScore;
}
