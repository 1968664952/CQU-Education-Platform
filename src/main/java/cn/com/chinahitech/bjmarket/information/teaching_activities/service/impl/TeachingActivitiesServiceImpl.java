package cn.com.chinahitech.bjmarket.information.teaching_activities.service.impl;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.entity.SearchTag;
import cn.com.chinahitech.bjmarket.information.teaching_activities.entity.TeachingActivities;
import cn.com.chinahitech.bjmarket.information.teaching_activities.mapper.TeachingActivitiesMapper;
import cn.com.chinahitech.bjmarket.information.teaching_activities.service.TeachingActivitiesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 教学活动信息表 服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
@Service
public class TeachingActivitiesServiceImpl extends ServiceImpl<TeachingActivitiesMapper, TeachingActivities> implements TeachingActivitiesService {
    @Autowired
    private TeachingActivitiesMapper teachingActivitiesMapper;

    @Override
    public void add(@RequestBody TeachingActivities new1) {
        //补充属性值
        teachingActivitiesMapper.add(new1);
    }

    @Override
    public PageBean<TeachingActivities> getlist(SearchTag searchTag) {
        //创建pb
        PageBean<TeachingActivities> pb = new PageBean<>();
        //开始分页查询Pagehelper
        PageHelper.startPage(searchTag.getPageNum(), searchTag.getPageSize());
        //调用mapper
        List<TeachingActivities> as = teachingActivitiesMapper.showlist(searchTag.getTitle(), searchTag.getOrganizer());
        //page中提供了方法，可以回去Pagehelper分页查询后，得到的总记录和当前页数据
        Page<TeachingActivities> p=(Page<TeachingActivities>) as;

        //把数据填会pb
        pb.setTotal((int)p.getTotal());
        pb.setProducts(p.getResult());
        return pb;
    }

    @Override
    public void toupdate(TeachingActivities activities){
        teachingActivitiesMapper.toupdate(activities);
    }

    @Override
    public void delete(MID id){
        teachingActivitiesMapper.todelete(id);
    }

    @Override
    public TeachingActivities findById(MID id){
        TeachingActivities ta = teachingActivitiesMapper.findById(id);
        return ta;
    }
}
