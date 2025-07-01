package cn.com.chinahitech.bjmarket.information.competition_message.service;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.information.competition_message.entity.CompetitionMessage;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.entity.SearchTag;
import cn.com.chinahitech.bjmarket.information.teaching_activities.entity.TeachingActivities;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 竞赛信息表 服务类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
public interface CompetitionMessageService extends IService<CompetitionMessage> {
    //新增文章
    void add(CompetitionMessage new1);
    //分页列表查询
    PageBean<CompetitionMessage> getlist(SearchTag searchTag);
    //更新文章
    void toupdate(CompetitionMessage cm);
    //删除文章
    void delete(MID id);
    //获取单个文章信息
    CompetitionMessage findById(MID id);
}
