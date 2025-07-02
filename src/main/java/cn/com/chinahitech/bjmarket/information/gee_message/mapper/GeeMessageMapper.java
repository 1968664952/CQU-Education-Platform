package cn.com.chinahitech.bjmarket.information.gee_message.mapper;

import cn.com.chinahitech.bjmarket.information.academic_journal.entity.AcademicJournal;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.gee_message.entity.GeeMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * 考研信息公示表 Mapper 接口
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
public interface GeeMessageMapper extends BaseMapper<GeeMessage> {
    @Insert("insert into gee_message(title,content,academy,category,attachment_link,view_count)"+
            "values(#{title},#{content},#{academy},#{category},#{attachmentLink},#{viewCount})")
    int add(GeeMessage new1);

    List<GeeMessage> showlist(String title, String organizer);

    @Update("update gee_message set title=#{title},content=#{content},academy=#{academy},category=#{category},attachment_link=#{attachmentLink} " +
            "where activity=#{activityId}")
    int toupdate(GeeMessage gm);

    @Delete("DELETE from gee_message where activity_id=#{id}")
    int todelete(MID id);

    @Select("select * from gee_message where activity_id=#{id}")
    GeeMessage findById(MID id);

    @Update("UPDATE gee_message SET view_count = view_count + 1 WHERE activity_id = #{id}")
    void incrementViews(MID id);
}
