package cn.com.chinahitech.bjmarket.personal.course_scores.service;

import cn.com.chinahitech.bjmarket.personal.course_scores.entity.*;
import cn.com.chinahitech.bjmarket.personal.course_scores.mapper.MyCourseScoresMapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 学生选课得分表 服务类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-02
 */
public interface MyCourseScoresService extends IService<MyCourseScores> {
    //查询学生得分情况
    List<CourseScoreData> getAll(String studentid);
    //获得GPA
    GPAInfo calculateGPA(String studentId);
    //获得应修学分和已修学分
    Credit getCreditSummary(String studentId);
    //获取必修课与选修课总数
    CourseCount getCourseCounts(String studentId);

}
