package cn.com.chinahitech.bjmarket.teaching_activities.service;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.teaching_activities.entity.TeachingActivities;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 教学活动信息表 服务类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
public interface TeachingActivitiesService extends IService<TeachingActivities> {
    //新增文章
    void add(TeachingActivities new1);
    //分页列表查询
    PageBean<TeachingActivities> getlist(Integer pageNum, Integer pageSize, String title, String organizer);
    //更新文章
    void toupdate(TeachingActivities activities);
    //删除文章
    void delete(int id);
    //获取单个文章信息
    TeachingActivities findById(Integer id);
}
