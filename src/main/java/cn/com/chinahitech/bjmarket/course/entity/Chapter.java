package cn.com.chinahitech.bjmarket.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class Chapter {
    @TableId(value = "chapter_id", type = IdType.AUTO)
    private Long chapterId;
    private Course courseId;
    private String title;
    private Integer position;
    private String url;
    private Integer duration;
    private String resolution;
    private LocalDateTime createdAt;
}
