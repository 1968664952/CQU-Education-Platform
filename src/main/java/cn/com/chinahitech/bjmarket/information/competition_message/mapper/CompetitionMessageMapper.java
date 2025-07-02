package cn.com.chinahitech.bjmarket.information.competition_message.mapper;

import cn.com.chinahitech.bjmarket.information.academic_journal.entity.AcademicJournal;
import cn.com.chinahitech.bjmarket.information.competition_message.entity.CompetitionMessage;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * 竞赛信息表 Mapper 接口
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
public interface CompetitionMessageMapper extends BaseMapper<CompetitionMessage> {
    @Insert("insert into competition_message(title,content,organizer,category,signup_open,signup_end,competition_date,signup_link,attachment_link,view_count)"+
            "values(#{title},#{content},#{organizer},#{category},#{signupOpen},#{signupEnd},#{competitionDate},#{attachmentLink},#{viewCount})")
    void add(CompetitionMessage new1);

    List<CompetitionMessage> showlist(String title, String organizer);

    @Update("update competition_message set title=#{title},content=#{content},organizer=#{organizer},category=#{category},signup_open=#{signupOpen},signup_end=#{signupEnd},competition_date=#{competitionDate},signup_link=#{signupLink},attachment_link=#{attachmentLink} " +
            "where competition_id=#{competitionId}")
    void toupdate(CompetitionMessage cm);

    @Delete("DELETE from competition_message where competition_id=#{id}")
    void todelete(MID id);

    @Select("select * from competition_message where competition_id=#{id}")
    CompetitionMessage findById(MID id);

    @Update("UPDATE competition_message SET view_count = view_count + 1 WHERE competition_id = #{id}")
    void incrementViews(MID id);
}
