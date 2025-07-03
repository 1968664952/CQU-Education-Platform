package cn.com.chinahitech.bjmarket.course.Mapper;

import cn.com.chinahitech.bjmarket.course.entity.CourseScores;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CourseScoresMapper extends BaseMapper<CourseScores> {
}
