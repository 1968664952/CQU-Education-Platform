package cn.com.chinahitech.bjmarket.course.Mapper;

import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {
    @Select("SELECT * FROM chapter WHERE chapter_id = #{chapterId}")
    Chapter findByChapterId(String chapterId);
}
