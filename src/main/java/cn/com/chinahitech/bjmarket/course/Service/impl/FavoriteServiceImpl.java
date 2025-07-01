package cn.com.chinahitech.bjmarket.course.Service.impl;

import cn.com.chinahitech.bjmarket.course.Mapper.FavoriteMapper;
import cn.com.chinahitech.bjmarket.course.Service.FavoriteService;
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
}
