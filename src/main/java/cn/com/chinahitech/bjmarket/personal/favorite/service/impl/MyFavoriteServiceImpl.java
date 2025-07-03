package cn.com.chinahitech.bjmarket.personal.favorite.service.impl;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import cn.com.chinahitech.bjmarket.personal.favorite.entity.MyFavorite;
import cn.com.chinahitech.bjmarket.personal.favorite.mapper.MyFavoriteMapper;
import cn.com.chinahitech.bjmarket.personal.favorite.service.MyFavoriteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程收藏表 服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-02
 */
@Service
public class MyFavoriteServiceImpl extends ServiceImpl<MyFavoriteMapper, MyFavorite> implements MyFavoriteService {
    @Autowired
    private MyFavoriteMapper myFavoriteMapper;

    @Override
    public PageBean<Course> getFavoriteCoursesPage(String studentId, int pageNum, int pageSize) {
        // 1. 开始分页
        PageHelper.startPage(pageNum, pageSize);

        // 2. 查询收藏课程详情
        List<Course> courses = myFavoriteMapper.findFavoriteCoursesByStudentId(studentId);

        // 3. 获取分页信息
        PageInfo<Course> pageInfo = new PageInfo<>(courses);

        // 4. 封装到PageBean
        return new PageBean<>(
                (int) pageInfo.getTotal(),
                pageInfo.getList()
        );
    }
}
