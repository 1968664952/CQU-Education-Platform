package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Mapper.CourseMapper;
import cn.com.chinahitech.bjmarket.course.Service.ChapterService;
import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import cn.com.chinahitech.bjmarket.course.Mapper.ChapterMapper;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import cn.com.chinahitech.bjmarket.course.entity.Favorite;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Chapter> queryChapterById(String CourseId) {
        List<Chapter> chapterList=null;
        QueryWrapper<Chapter> wrapper=new QueryWrapper<Chapter>();

        wrapper.eq("course_id",CourseId);

        chapterList=chapterMapper.selectList(wrapper);

        // 2. 更新total_play_count（无论是否存在章节，只要course_id存在则更新）
        UpdateWrapper<Course> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("course_id", CourseId) // 匹配course_id
                .setSql("total_play_count = total_play_count + 1"); // 播放次数+1
        courseMapper.update(null, updateWrapper);

        return chapterList;
    }

    @Override
    public int addChapter(Chapter chapter) {
        int count=chapterMapper.insert(chapter);
        return count;
    }

    @Override
    public Chapter queryOneChapter(int chapterId) {
        Chapter chapter=null;
        QueryWrapper<Chapter> wrapper=new QueryWrapper<Chapter>();

        wrapper.eq("chapter_id",chapterId);
        chapter=chapterMapper.selectOne(wrapper);
        return chapter;
    }

    @Override
    public int delChapter(int chapterId) {
        QueryWrapper<Chapter> wrapper= new QueryWrapper<Chapter>();
        wrapper.eq("chapter_id",chapterId);

        int result=chapterMapper.delete(wrapper);
        return result;
    }
}
