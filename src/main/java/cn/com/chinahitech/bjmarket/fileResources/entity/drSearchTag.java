package cn.com.chinahitech.bjmarket.fileResources.entity;

import lombok.Data;

@Data
public class drSearchTag {
    int pageNum;
    int pageSize;
    String primaryCategory;
    String secondaryCategory;
    String useyear;
    String applicableMajor;
    String applicableGrade;
}
