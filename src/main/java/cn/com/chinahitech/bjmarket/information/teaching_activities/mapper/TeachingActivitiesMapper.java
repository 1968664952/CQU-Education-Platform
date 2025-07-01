package cn.com.chinahitech.bjmarket.information.teaching_activities.mapper;

import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.teaching_activities.entity.TeachingActivities;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * 教学活动信息表 Mapper 接口
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
public interface TeachingActivitiesMapper extends BaseMapper<TeachingActivities> {
    @Insert("insert into teaching_activities(title,content,organizer,category,activity_begin,activity_end,view_count)"+
            "values(#{title},#{content},#{organizer},#{category},#{activityBegin},#{activityEnd},#{viewCount})")
    void add(TeachingActivities new1);

    List<TeachingActivities> showlist(String title, String organizer);

    @Update("update teaching_activities set title=#{title},content=#{content},organizer=#{organizer},category=#{category},activity_begin=#{activityBegin},activity_end=#{activityEnd} " +
            "where activity_id=#{activityId}")
    void toupdate(TeachingActivities ta);

    @Delete("DELETE from teaching_activities where activity_id=#{id}")
    void todelete(MID id);

    @Select("select * from teaching_activities where activity_id=#{id}")
    TeachingActivities findById(MID id);
}
