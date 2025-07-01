package cn.com.chinahitech.bjmarket.course.Mapper;

import cn.com.chinahitech.bjmarket.course.entity.Favorite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FavoriteMapper extends BaseMapper<Favorite> {
    @Select("SELECT * FROM favorite WHERE favorite_id = #{favoriteId}")
    Favorite findByFavoriteId(String favoriteId);
}
