package cn.com.chinahitech.bjmarket.login.Mapper;

import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import cn.com.chinahitech.bjmarket.login.entity.DailyVisits;
import cn.com.chinahitech.bjmarket.login.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DailyVisitsMapper extends BaseMapper<DailyVisits> {
    @Insert("INSERT INTO daily_visits (date, count)\n" +
            "VALUES (CURDATE(), 1)\n" +
            "ON DUPLICATE KEY UPDATE count = count + 1;")
    void addDailyVisits();
}
