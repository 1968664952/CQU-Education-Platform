package cn.com.chinahitech.bjmarket.login.Service.impl;

import cn.com.chinahitech.bjmarket.login.Mapper.DailyVisitsMapper;
import cn.com.chinahitech.bjmarket.login.Mapper.StudentMapper;
import cn.com.chinahitech.bjmarket.login.Service.DailyVisitsService;
import cn.com.chinahitech.bjmarket.login.Service.StudentService;
import cn.com.chinahitech.bjmarket.login.entity.DailyVisits;
import cn.com.chinahitech.bjmarket.login.entity.Student;
import cn.com.chinahitech.bjmarket.utils.HashUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailyvisitsServiceImpl implements DailyVisitsService {

    @Autowired
    private DailyVisitsMapper dailyVisitsMapper;


    @Override
    public void addDailyVisit() {
        dailyVisitsMapper.addDailyVisits();
    }

    @Override
    public List<DailyVisits> getDailyVisit() {
        List<DailyVisits> dailyVisits=null;
        QueryWrapper<DailyVisits> wrapper=new QueryWrapper<DailyVisits>();

        LocalDate oneWeekAgo = LocalDate.now().minusDays(7); // 7天前的日期
        LocalDate today = LocalDate.now(); // 今天
        wrapper.between("date", oneWeekAgo,today);

        dailyVisits=dailyVisitsMapper.selectList(wrapper);
        return dailyVisits;
    }
}
