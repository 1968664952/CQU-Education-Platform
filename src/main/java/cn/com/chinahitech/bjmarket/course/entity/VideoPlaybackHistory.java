package cn.com.chinahitech.bjmarket.course.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class VideoPlaybackHistory {
    private Integer id;
    private String studentId;
    private Integer chapterId;
    private Integer position;
    private Integer lastPosition;
    private Timestamp lastPlayedTime;
}
