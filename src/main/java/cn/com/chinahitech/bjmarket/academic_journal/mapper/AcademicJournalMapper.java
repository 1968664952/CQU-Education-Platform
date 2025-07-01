package cn.com.chinahitech.bjmarket.academic_journal.mapper;

import cn.com.chinahitech.bjmarket.academic_journal.entity.AcademicJournal;
import cn.com.chinahitech.bjmarket.login.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 学术期刊信息表 Mapper 接口
 * </p>
 *
 * @author zhufu
 * @since 2025-06-30
 */
@Mapper
public interface AcademicJournalMapper extends BaseMapper<AcademicJournal> {
    @Insert("insert into academic_journal(title,content,author,publish_time,publisher,category,publish_date,attachment_link,view_count)"+
            "values(#{title},#{content},#{author},#{publishTime},#{publisher},#{category},#{publishDate},#{attachmentLink},#{viewCount})")
    void add(AcademicJournal new1);

    @Select("select * from academic_journal")
    List<AcademicJournal> showlist(String title,String publisher);

    @Update("update academic_journal set title=#{title},content=#{content},author=#{author},publisher=#{publisher},category=#{category},attachment_link=#{attachmentLink} " +
            "where journal_id=#{journalId}")
    void toupdate(AcademicJournal journal);

    @Delete("DELETE from academic_journal where journal_id=#{id}")
    void todelete(int id);

    @Select("select * from academic_journal where journal_id=#{id}")
    AcademicJournal findById(Integer id);
//    @Select("SELECT * FROM journal WHERE journal_id = #{journalId}")
//    AcademicJournal findByJournalId(int journalId);
}
