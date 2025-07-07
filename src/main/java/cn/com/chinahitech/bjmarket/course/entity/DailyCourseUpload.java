package cn.com.chinahitech.bjmarket.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class DailyCourseUpload {
    @TableId(value = "date", type = IdType.AUTO)
    private String date;
    private Integer courseCount;
}
