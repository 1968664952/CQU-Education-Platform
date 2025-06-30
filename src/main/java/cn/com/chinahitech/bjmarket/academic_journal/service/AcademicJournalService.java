package cn.com.chinahitech.bjmarket.academic_journal.service;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.academic_journal.entity.AcademicJournal;
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
    void add(AcademicJournal new1);
    //分页列表查询
    PageBean<AcademicJournal> getlist(Integer pageNum, Integer pageSize, String title,String publisher);
    //更新文章
    void toupdate(AcademicJournal journal);
    //删除文章
    void delete(int id);
    //获取单个文章信息
    AcademicJournal findById(Integer id);
}
