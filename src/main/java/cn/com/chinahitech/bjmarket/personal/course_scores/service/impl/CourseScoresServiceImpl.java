package cn.com.chinahitech.bjmarket.personal.course_scores.service.impl;

import cn.com.chinahitech.bjmarket.personal.course_scores.entity.CourseScores;
import cn.com.chinahitech.bjmarket.personal.course_scores.mapper.CourseScoresMapper;
import cn.com.chinahitech.bjmarket.personal.course_scores.service.CourseScoresService;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 学生选课得分表 服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-02
 */
@Service
public class CourseScoresServiceImpl extends ServiceImpl<CourseScoresMapper, CourseScores> implements CourseScoresService {
    @Autowired
    private CourseScoresMapper courseScoresMapper;

    @Override
    public  List<CourseScores> getAll(String studentid){
        List<CourseScores> cs = courseScoresMapper.getAll(studentid);
        return cs;
    }


}
