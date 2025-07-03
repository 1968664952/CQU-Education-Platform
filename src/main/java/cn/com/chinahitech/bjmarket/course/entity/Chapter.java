package cn.com.chinahitech.bjmarket.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;
@Data
public class Chapter {
    @TableId(value = "chapter_id", type = IdType.AUTO)
    private Integer chapterId;
    @Setter
    private String courseId;
    @Setter
    private String title;
    @Setter
    private Integer position;
    @Setter
    private String url;
    private Integer duration;
    private String resolution;
    private LocalDateTime createdAt;
}
