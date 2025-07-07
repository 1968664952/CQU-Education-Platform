package cn.com.chinahitech.bjmarket.login.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class DailyVisits {
    private String date;
    private Integer count;
}
