package cn.com.chinahitech.bjmarket.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseKu {
    @TableId(value = "c_bank_id", type = IdType.AUTO)
    private Integer cBankId;
    private String cBankName;
    private String description;
    private String category;
    private LocalDateTime createdAt;
}
