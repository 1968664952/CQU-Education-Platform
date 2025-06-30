package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Service.ChapterService;
import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import cn.com.chinahitech.bjmarket.course.Mapper.ChapterMapper;
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
}
