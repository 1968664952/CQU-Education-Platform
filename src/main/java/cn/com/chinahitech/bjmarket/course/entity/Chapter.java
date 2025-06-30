package cn.com.chinahitech.bjmarket.course.entity;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class Chapter {
    private Long chapterId;
    private Course course;
    private String title;
    private Integer position;
    private String url;
    private Integer duration;
    private String resolution;
    private LocalDateTime createdAt;
}
