package cn.com.chinahitech.bjmarket.information.gee_message.service.impl;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.information.gee_message.entity.GeeMessage;
import cn.com.chinahitech.bjmarket.information.gee_message.mapper.GeeMessageMapper;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.entity.SearchTag;
import cn.com.chinahitech.bjmarket.information.gee_message.service.GeeMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 考研信息公示表 服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
@Service
public class GeeMessageServiceImpl extends ServiceImpl<GeeMessageMapper, GeeMessage> implements GeeMessageService {
    @Autowired
    private GeeMessageMapper geeMessageMapper;

    @Override
    public int add(@RequestBody GeeMessage new1) {
        //补充属性值
        int res = geeMessageMapper.add(new1);
        return res;
    }

    @Override
    public PageBean<GeeMessage> getlist(SearchTag searchTag) {
        //创建pb
        PageBean<GeeMessage> pb = new PageBean<>();
        //开始分页查询Pagehelper
        PageHelper.startPage(searchTag.getPageNum(), searchTag.getPageSize());
        //调用mapper
        List<GeeMessage> as = geeMessageMapper.showlist(searchTag.getTitle(), searchTag.getOrganizer());
        //page中提供了方法，可以回去Pagehelper分页查询后，得到的总记录和当前页数据
        Page<GeeMessage> p=(Page<GeeMessage>) as;

        //把数据填会pb
        pb.setTotal((int)p.getTotal());
        pb.setProducts(p.getResult());
        return pb;
    }

    @Override
    public int toupdate(GeeMessage gm){
        int res = geeMessageMapper.toupdate(gm);
        return res;
    }

    @Override
    public int delete(MID id){
        int res = geeMessageMapper.todelete(id);
        return res;
    }

    @Override
    public GeeMessage findById(MID id){
        GeeMessage gm = geeMessageMapper.findById(id);
        geeMessageMapper.incrementViews(id);
        return gm;
    }
}
