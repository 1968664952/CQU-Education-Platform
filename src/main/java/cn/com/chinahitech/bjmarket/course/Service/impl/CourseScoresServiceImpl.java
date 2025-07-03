package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Mapper.CourseKuMapper;
import cn.com.chinahitech.bjmarket.course.Mapper.CourseScoresMapper;
import cn.com.chinahitech.bjmarket.course.Service.CourseKuService;
import cn.com.chinahitech.bjmarket.course.Service.CourseScoreService;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import cn.com.chinahitech.bjmarket.course.entity.CourseKu;
import cn.com.chinahitech.bjmarket.course.entity.CourseScores;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseScoresServiceImpl implements CourseScoreService {

    @Autowired
    private CourseScoresMapper courseScoresMapper;

    @Override
    public List<CourseScores> queryLearnedCourse(String studentId) {
        List<CourseScores> courseScoresList=null;
        QueryWrapper<CourseScores> wrapper=new QueryWrapper<CourseScores>();

        wrapper.select("course_name").eq("student_id",studentId).between("course_score",60,100);

        courseScoresList=courseScoresMapper.selectList(wrapper);

        return courseScoresList;
    }

}
