package cn.com.chinahitech.bjmarket.personal.favorite.service;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import cn.com.chinahitech.bjmarket.personal.favorite.entity.MyFavorite;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程收藏表 服务类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-02
 */
public interface MyFavoriteService extends IService<MyFavorite> {
    PageBean<Course> getFavoriteCoursesPage(String studentId, int pageNum, int pageSize);
}
