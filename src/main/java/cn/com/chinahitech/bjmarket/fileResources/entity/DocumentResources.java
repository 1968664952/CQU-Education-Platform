package cn.com.chinahitech.bjmarket.fileResources.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.Year;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文档资源表
 * </p>
 *
 * @author zhufu
 * @since 2025-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("document_resources")
public class DocumentResources implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 资源标题
     */
    private String title;

    /**
     * 一级分类标签
     */
    private String primaryCategory;

    /**
     * 二级分类标签
     */
    private String secondaryCategory;

    /**
     * 年份
     */
    private String useyear;

    /**
     * 浏览量
     */
    private Integer viewCount;

    /**
     * 下载量
     */
    private Integer downloadCount;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 资源文件路径
     */
    private String filePath;

    /**
     * 作者ID
     */
    private String authorId;

    /**
     * 作者名称
     */
    private String authorName;

    /**
     * 激活状态: 0-待审核, 1-已激活, 2-已拒绝
     */
    private Boolean status;

    /**
     * 适用专业
     */
    private String applicableMajor;

    /**
     * 适用年级
     */
    private String applicableGrade;


}
