package cn.com.chinahitech.bjmarket.course.Service;

import cn.com.chinahitech.bjmarket.course.entity.DailyCourseUpload;

import java.util.List;

public interface VideoPlaybackHistoryService {
    int saveOrUpdateHistory(String studentId, int chapterId, int position, int lastPosition);

    int getLastPosition(String studentId, int chapterId, int position);
}
