package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Mapper.FavoriteMapper;
import cn.com.chinahitech.bjmarket.course.Service.FavoriteService;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import cn.com.chinahitech.bjmarket.course.entity.Favorite;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public int addFavorite(Favorite favorite) {
        int count=favoriteMapper.insert(favorite);
        return count;
    }

    @Override
    public List<Favorite> queryFavoriteById(String courseId, String studentId) {
        List<Favorite> favoriteList=null;
        QueryWrapper<Favorite> wrapper= new QueryWrapper<Favorite>();
        wrapper.eq("student_id",studentId)
                .eq("course_id",courseId);

        favoriteList=favoriteMapper.selectList(wrapper);

        return favoriteList;
    }

    @Override
    public int deleteFavorite(String courseId, String studentId) {
        QueryWrapper<Favorite> wrapper= new QueryWrapper<Favorite>();
        wrapper.eq("student_id",studentId)
                .eq("course_id",courseId);

        int result=favoriteMapper.delete(wrapper);
        return result;
    }
}
