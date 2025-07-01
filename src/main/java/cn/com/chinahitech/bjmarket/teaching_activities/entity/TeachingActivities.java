package cn.com.chinahitech.bjmarket.teaching_activities.entity;

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
 * 教学活动信息表
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("teaching_activities")
public class TeachingActivities implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动ID
     */
    @TableId(value = "activity_id", type = IdType.AUTO)
    private Integer activityId;

    /**
     * 活动名称
     */
    private String title;

    /**
     * 活动描述
     */
    private String content;

    /**
     * 举办单位
     */
    private String organizer;

    /**
     * 类别
     */
    private String category;

    /**
     * 活动开始时间
     */
    private LocalDateTime activityBegin;

    /**
     * 活动截止日期
     */
    private LocalDateTime activityEnd;

    /**
     * 浏览量
     */
    private Integer viewCount;


}
