package cn.com.chinahitech.bjmarket.personal.course_scores.service.impl;

import cn.com.chinahitech.bjmarket.course.Mapper.CourseScoresMapper;
import cn.com.chinahitech.bjmarket.personal.course_scores.entity.*;
import cn.com.chinahitech.bjmarket.personal.course_scores.mapper.MyCourseScoresMapper;
import cn.com.chinahitech.bjmarket.personal.course_scores.service.MyCourseScoresService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
    public  List<CourseScoreData> getAll(String studentid){
        List<CourseScoreData> cs = myCourseScoresMapper.getAll(studentid);
        return cs;
    }

    private double getGradePoint(int score) {
        if (score >= 90) return 4.0;
        if (score >= 60){
            double GPA = (score/10)-5;
        }
        return 0.0;
    }

    @Override
    public GPAInfo calculateGPA(String studentId) {
        List<CourseScoreData> courses = myCourseScoresMapper.getAll(studentId);
        if (courses == null || courses.isEmpty()) {
            return new GPAInfo(studentId, 0.0);
        }

        double totalPoints = 0.0;
        int totalCredits = 0;

        for (CourseScoreData course : courses) {
            double point = getGradePoint(course.getCourseScore());
            totalPoints += point * course.getCourseCredit();
            totalCredits += course.getCourseCredit();
        }

        double gpa = totalCredits > 0 ? Math.round(totalPoints / totalCredits*10)/10.0 : 0.0;
        return new GPAInfo(studentId, gpa);
    }

    @Override
    public Credit getCreditSummary(String studentId) {
        return myCourseScoresMapper.getCreditRequirementWithEarned(studentId);
    }

    @Override
    public CourseCount getCourseCounts(String studentId) {
        return myCourseScoresMapper.getCourseCounts(studentId);
    }

}
