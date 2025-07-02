package cn.com.chinahitech.bjmarket.personal.course_scores.mapper;

import cn.com.chinahitech.bjmarket.personal.course_scores.entity.CourseScores;
import cn.com.chinahitech.bjmarket.information.entity.MID;
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
public interface CourseScoresMapper extends BaseMapper<CourseScores> {
    @Select("select * from course_scores where student_id=#{studentid}")
    List<CourseScores> getAll(String studentid);
}
