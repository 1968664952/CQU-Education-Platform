package cn.com.chinahitech.bjmarket.information.competition_message.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 竞赛信息表
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("competition_message")
public class CompetitionMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 竞赛ID
     */
    @TableId(value = "competition_id", type = IdType.AUTO)
    private Integer competitionId;

    /**
     * 竞赛名称
     */
    private String title;

    /**
     * 竞赛简介
     */
    private String content;

    /**
     * 主办单位
     */
    private String organizer;

    /**
     * 类别
     */
    private String category;

    /**
     * 报名开始日期
     */
    private LocalDate signupOpen;

    /**
     * 报名截止日期
     */
    private LocalDate signupEnd;

    /**
     * 正式比赛日期
     */
    private LocalDate competitionDate;

    /**
     * 报名链接
     */
    private String signupLink;

    /**
     * 附件说明链接
     */
    private String attachmentLink;

    /**
     * 浏览量
     */
    private Integer viewCount;

    private  String participants;


}
