package cn.com.chinahitech.bjmarket.personal.favorite.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程收藏表
 * </p>
 *
 * @author zhufu
 * @since 2025-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("favorite")
public class MyFavorite implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏ID
     */
    @TableId(value = "favorite_id", type = IdType.AUTO)
    private Integer favoriteId;

    /**
     * 学生ID
     */
    private String studentId;

    /**
     * 课程ID
     */
    private Integer courseId;

    /**
     * 收藏时间
     */
    private LocalDateTime createdAt;


}
