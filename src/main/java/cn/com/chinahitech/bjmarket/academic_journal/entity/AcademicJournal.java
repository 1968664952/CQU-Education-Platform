package cn.com.chinahitech.bjmarket.academic_journal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学术期刊信息表
 * </p>
 *
 * @author zhufu
 * @since 2025-06-30
 */
@Data
public class AcademicJournal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 期刊ID
     *
     */

    @TableId(value = "journal_id", type = IdType.AUTO)
    private Integer journalId;
    /**
     * 期刊标题
     */
    private String title;
    /**
     * 期刊内容摘要
     */
    private String content;
    /**
     * 作者列表
     */
    private String author;
    /**
     * 发表时间
     */
    private LocalDate publishTime;
    /**
     * 期刊出版社
     */
    private String publisher;
    /**
     * 领域分类
     */
    private String category;
    /**
     * 发布日期
     */
    private LocalDate publishDate;

    /**
     * 附件下载地址/期刊链接
     */
    private String attachmentLink;

    /**
     * 浏览量
     */
    private Integer viewCount;


}
