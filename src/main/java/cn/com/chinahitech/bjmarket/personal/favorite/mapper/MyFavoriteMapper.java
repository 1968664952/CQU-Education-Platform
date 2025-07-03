package cn.com.chinahitech.bjmarket.personal.favorite.mapper;

import cn.com.chinahitech.bjmarket.course.entity.Course;
import cn.com.chinahitech.bjmarket.personal.favorite.entity.MyFavorite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 课程收藏表 Mapper 接口
 * </p>
 *
 * @author zhufu
 * @since 2025-07-02
 */
@Mapper
public interface MyFavoriteMapper extends BaseMapper<MyFavorite> {
    @Select("SELECT c.* FROM course c " +
            "JOIN favorite f ON c.course_id = f.course_id " +
            "WHERE f.student_id = #{studentId} " +
            "ORDER BY f.created_at DESC")
    List<Course> findFavoriteCoursesByStudentId(String studentId);
}
