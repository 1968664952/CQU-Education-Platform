package cn.com.chinahitech.bjmarket.personal.course_scores.mapper;

import cn.com.chinahitech.bjmarket.personal.course_scores.entity.CourseCount;
import cn.com.chinahitech.bjmarket.personal.course_scores.entity.CourseScoreData;
import cn.com.chinahitech.bjmarket.personal.course_scores.entity.Credit;
import cn.com.chinahitech.bjmarket.personal.course_scores.entity.MyCourseScores;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 学生选课得分表 Mapper 接口
 * </p>
 *
 * @author zhufu
 * @since 2025-07-02
 */
@Mapper
public interface MyCourseScoresMapper extends BaseMapper<MyCourseScores> {
    @Select("select course_name, course_score, course_credit from course_scores where student_id=#{studentid}")
    List<CourseScoreData> getAll(String studentid);

    @Select("SELECT course_score FROM course_scores WHERE student_id = #{studentId}")
    List<Integer> findCourseScoresByStudentId(String studentId);

    @Select("SELECT " +
            "  scr.required_credits AS nRCredit, " +
            "  scr.elective_credits AS nECredit, " +
            "  COALESCE(SUM(CASE WHEN cs.category = '必修' THEN cs.course_credit END), 0) AS gRCredit, " +
            "  COALESCE(SUM(CASE WHEN cs.category = '选修' THEN cs.course_credit END), 0) AS gECredit " +
            "FROM student_credit_requirements scr " +
            "LEFT JOIN course_scores cs ON scr.student_id = cs.student_id " +
            "WHERE scr.student_id = #{studentId} " +
            "GROUP BY scr.student_id")
    Credit getCreditRequirementWithEarned(String studentId);

    @Select("SELECT " +
            "    COUNT(CASE WHEN category = '必修' THEN 1 END) AS rcount, " +
            "    COUNT(CASE WHEN category = '选修' THEN 1 END) AS ecount " +
            "FROM course_scores " +
            "WHERE student_id = #{studentId}")
    CourseCount getCourseCounts(String studentId);

}
