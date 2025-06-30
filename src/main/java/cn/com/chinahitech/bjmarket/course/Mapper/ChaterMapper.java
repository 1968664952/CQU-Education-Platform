package cn.com.chinahitech.bjmarket.course.Mapper;

import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChaterMapper {
    @Select("SELECT * FROM charter WHERE charter_id = #{chapterId}")
    Chapter findByCharterId(String charterId);
}
