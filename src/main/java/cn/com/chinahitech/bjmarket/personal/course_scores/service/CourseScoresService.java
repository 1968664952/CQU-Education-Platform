package cn.com.chinahitech.bjmarket.personal.course_scores.service;

import cn.com.chinahitech.bjmarket.login.entity.Student;
import cn.com.chinahitech.bjmarket.personal.course_scores.entity.CourseScores;
import cn.com.chinahitech.bjmarket.information.entity.MID;
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
public interface CourseScoresService extends IService<CourseScores> {
    //查询学生得分情况
    List<CourseScores> getAll(String studentid);
}
