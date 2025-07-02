package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Mapper.ChapterMapper;
import cn.com.chinahitech.bjmarket.course.Mapper.CourseKuMapper;
import cn.com.chinahitech.bjmarket.course.Service.ChapterService;
import cn.com.chinahitech.bjmarket.course.Service.CourseKuService;
import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import cn.com.chinahitech.bjmarket.course.entity.CourseKu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseKuServiceImpl implements CourseKuService {

    @Autowired
    private CourseKuMapper courseKuMapper;

    @Override
    public int queryIdBymajor(String major) {
        CourseKu courseKu;
        QueryWrapper<CourseKu> wrapper=new QueryWrapper<CourseKu>();
        wrapper.eq("category",major);
        courseKu=courseKuMapper.selectOne(wrapper);
        int result=courseKu.getCBankId();
        return result;
    }
}
