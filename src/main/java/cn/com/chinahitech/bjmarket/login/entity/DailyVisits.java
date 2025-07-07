package cn.com.chinahitech.bjmarket.login.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class DailyVisits {
    @TableId(value = "date", type = IdType.AUTO)
    private String date;
    private Integer count;
}
