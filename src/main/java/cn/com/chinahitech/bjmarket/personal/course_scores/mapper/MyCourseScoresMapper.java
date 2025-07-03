package cn.com.chinahitech.bjmarket.personal.course_scores.mapper;

import cn.com.chinahitech.bjmarket.personal.course_scores.entity.CourseScoreData;
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


    @Select("SELECT COALESCE(SUM(course_credit), 0) " +
            "FROM course_scores " +
            "WHERE student_id = #{studentId}")
    int getTotalCreditsByStudentId(String studentId);


}
