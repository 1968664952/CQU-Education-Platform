package cn.com.chinahitech.bjmarket.information.gee_message.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 考研信息公示表
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gee_message")
public class GeeMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公示ID
     */
    @TableId(value = "activity_id", type = IdType.AUTO)
    private Integer activityId;

    /**
     * 公示标题
     */
    private String title;

    /**
     * 正文内容
     */
    private String content;

    /**
     * 发布学院
     */
    private String academy;

    /**
     * 公示类别
     */
    private String category;

    /**
     * 附件链接
     */
    private String attachmentLink;

    /**
     * 浏览量
     */
    private Integer viewCount;


}
