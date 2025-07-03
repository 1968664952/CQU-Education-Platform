package cn.com.chinahitech.bjmarket.information.gee_message.service;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.information.competition_message.entity.CompetitionMessage;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.entity.SearchTag;
import cn.com.chinahitech.bjmarket.information.gee_message.entity.GeeMessage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 考研信息公示表 服务类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
public interface GeeMessageService extends IService<GeeMessage> {
    //新增文章
    int add(GeeMessage new1);
    //分页列表查询
    PageBean<GeeMessage> getlist(SearchTag searchTag);
    //更新文章
    int toupdate(GeeMessage cm);
    //删除文章
    int delete(MID id);
    //获取单个文章信息
    GeeMessage findById(MID id);
    GeeMessage findByIdAdmin(MID id);
}
