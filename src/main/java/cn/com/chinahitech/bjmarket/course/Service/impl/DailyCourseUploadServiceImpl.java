package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Mapper.CourseScoresMapper;
import cn.com.chinahitech.bjmarket.course.Mapper.DailyCourseUploadMapper;
import cn.com.chinahitech.bjmarket.course.Service.CourseScoreService;
import cn.com.chinahitech.bjmarket.course.Service.DailyCourseUploadService;
import cn.com.chinahitech.bjmarket.course.entity.CourseScores;
import cn.com.chinahitech.bjmarket.course.entity.DailyCourseUpload;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailyCourseUploadServiceImpl implements DailyCourseUploadService {

    @Autowired
    private DailyCourseUploadMapper dailyCourseUploadMapper;

    @Override
    public List<DailyCourseUpload> queryUpload() {
        List<DailyCourseUpload> dailyCourseUploads=null;
        QueryWrapper<DailyCourseUpload> wrapper = new QueryWrapper<DailyCourseUpload>();

        LocalDate oneWeekAgo = LocalDate.now().minusDays(7); // 7天前的日期
        LocalDate today = LocalDate.now(); // 今天
        wrapper.between("date", oneWeekAgo,today);

        dailyCourseUploads=dailyCourseUploadMapper.selectList(wrapper);

        return dailyCourseUploads;
    }

}
