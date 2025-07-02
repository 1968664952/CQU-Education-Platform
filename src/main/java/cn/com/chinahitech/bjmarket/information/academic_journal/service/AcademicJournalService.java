package cn.com.chinahitech.bjmarket.information.academic_journal.service;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.information.academic_journal.entity.AcademicJournal;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.entity.SearchTag;
import cn.com.chinahitech.bjmarket.information.gee_message.entity.GeeMessage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 学术期刊信息表 服务类
 * </p>
 *
 * @author zhufu
 * @since 2025-06-30
 */
public interface AcademicJournalService extends IService<AcademicJournal> {
    //新增文章
    int add(AcademicJournal new1);
    //分页列表查询
    PageBean<AcademicJournal> getlist(SearchTag searchTag);
    //更新文章
    int toupdate(AcademicJournal journal);
    //删除文章
    int delete(MID id);
    //获取单个文章信息
    AcademicJournal findById(MID id);
}
