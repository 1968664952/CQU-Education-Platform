package cn.com.chinahitech.bjmarket.course.entity;

import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class Favorite {
    private Long favoriteId;
    @Setter
    private String studentId;
    @Setter
    private String courseId;
    private LocalDateTime createdAt;
}
