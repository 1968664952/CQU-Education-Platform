package cn.com.chinahitech.bjmarket.course.Service;

import cn.com.chinahitech.bjmarket.course.entity.CourseScores;
import cn.com.chinahitech.bjmarket.course.entity.DailyCourseUpload;

import java.util.List;

public interface DailyCourseUploadService {
    List<DailyCourseUpload> queryUpload();
}
