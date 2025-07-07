package cn.com.chinahitech.bjmarket.login.Service;

import cn.com.chinahitech.bjmarket.login.entity.DailyVisits;
import cn.com.chinahitech.bjmarket.login.entity.Student;

public interface DailyVisitsService {
    void addDailyVisit();

    DailyVisits getDailyVisit();
}
