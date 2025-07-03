package cn.com.chinahitech.bjmarket.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class Favorite {
    @TableId(value = "favorite_id", type = IdType.AUTO)
    private Long favoriteId;
    @Setter
    private String studentId;
    @Setter
    private String courseId;
    private LocalDateTime createdAt;
}
