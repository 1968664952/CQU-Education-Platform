package cn.com.chinahitech.bjmarket.course.Service;

import cn.com.chinahitech.bjmarket.course.entity.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> queryChapterById(String CourseId);
}
