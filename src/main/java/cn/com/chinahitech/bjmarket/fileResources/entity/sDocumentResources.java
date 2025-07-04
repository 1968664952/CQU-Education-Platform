package cn.com.chinahitech.bjmarket.fileResources.entity;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class sDocumentResources {
    int id;
    /**
     * 资源标题
     */
    String title;
    /**
     * 一级分类标签
     */
    String primaryCategory;
    /**
     * 二级分类标签
     */
    String secondaryCategory;
    /**
     * 年份
     */
    String useyear;
    /**
     * 浏览量
     */
    int viewCount;
    /**
     * 下载量
     */
    int downloadCount;
    /**
     * 发布时间
     */
    int publishTime;
    /**
     * 作者名称
     */
    String authorName;
    /**
     * 适用专业
     */
    String applicableMajor;
    /**
     * 适用年级
     */
    String applicableGrade;
}
