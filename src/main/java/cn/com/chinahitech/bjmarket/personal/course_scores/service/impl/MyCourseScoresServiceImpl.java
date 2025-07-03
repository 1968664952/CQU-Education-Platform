package cn.com.chinahitech.bjmarket.personal.course_scores.service.impl;

import cn.com.chinahitech.bjmarket.personal.course_scores.entity.MyCourseScores;
import cn.com.chinahitech.bjmarket.personal.course_scores.mapper.MyCourseScoresMapper;
import cn.com.chinahitech.bjmarket.personal.course_scores.service.MyCourseScoresService;
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
public class MyCourseScoresServiceImpl extends ServiceImpl<MyCourseScoresMapper, MyCourseScores> implements MyCourseScoresService {
    @Autowired
    private MyCourseScoresMapper myCourseScoresMapper;

    @Override
    public  List<MyCourseScores> getAll(String studentid){
        List<MyCourseScores> cs = myCourseScoresMapper.getAll(studentid);
        return cs;
    }


}
