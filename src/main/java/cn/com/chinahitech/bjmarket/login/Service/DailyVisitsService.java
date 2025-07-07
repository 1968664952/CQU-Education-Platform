package cn.com.chinahitech.bjmarket.login.Service;

import cn.com.chinahitech.bjmarket.login.entity.DailyVisits;
import cn.com.chinahitech.bjmarket.login.entity.Student;

import java.util.List;

public interface DailyVisitsService {
    void addDailyVisit();

    List<DailyVisits> getDailyVisit();
}
