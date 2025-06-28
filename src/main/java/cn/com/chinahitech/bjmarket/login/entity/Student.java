package cn.com.chinahitech.bjmarket.login.entity;

import lombok.Data;

@Data
public class Student {
    private String studentId;
    private String passwordHash;
    private String realName;
    private String avatarUrl;
    private Integer enrollmentYear;
    private Integer grade;
    private String majorName;
}
