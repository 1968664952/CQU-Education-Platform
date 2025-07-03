package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Service.ChapterService;
import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import cn.com.chinahitech.bjmarket.course.Mapper.ChapterMapper;
import cn.com.chinahitech.bjmarket.course.entity.Favorite;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;


    @Override
    public List<Chapter> queryChapterById(String CourseId) {
        List<Chapter> chapterList=null;
        QueryWrapper<Chapter> wrapper=new QueryWrapper<Chapter>();

        wrapper.eq("course_id",CourseId);

        chapterList=chapterMapper.selectList(wrapper);

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
