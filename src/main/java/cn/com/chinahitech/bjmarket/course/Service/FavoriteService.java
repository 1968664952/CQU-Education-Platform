package cn.com.chinahitech.bjmarket.course.Service;

import cn.com.chinahitech.bjmarket.course.entity.Favorite;

import java.util.List;

public interface FavoriteService {
    int addFavorite(Favorite favorite);
    List<Favorite> queryFavoriteById(String courseId, String studentId);
    int deleteFavorite(String courseId, String studentId);
}
