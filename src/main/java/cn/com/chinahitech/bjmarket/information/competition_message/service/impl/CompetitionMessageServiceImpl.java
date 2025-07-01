package cn.com.chinahitech.bjmarket.information.competition_message.service.impl;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.information.academic_journal.entity.AcademicJournal;
import cn.com.chinahitech.bjmarket.information.academic_journal.mapper.AcademicJournalMapper;
import cn.com.chinahitech.bjmarket.information.competition_message.entity.CompetitionMessage;
import cn.com.chinahitech.bjmarket.information.competition_message.mapper.CompetitionMessageMapper;
import cn.com.chinahitech.bjmarket.information.competition_message.service.CompetitionMessageService;
import cn.com.chinahitech.bjmarket.information.competition_message.service.impl.CompetitionMessageServiceImpl;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.entity.SearchTag;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 竞赛信息表 服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
@Service
public class CompetitionMessageServiceImpl extends ServiceImpl<CompetitionMessageMapper, CompetitionMessage> implements CompetitionMessageService {
    @Autowired
    private CompetitionMessageMapper competitionMessageMapper;

    @Override
    public void add(@RequestBody CompetitionMessage new1) {
        //补充属性值
        competitionMessageMapper.add(new1);
    }

    @Override
    public PageBean<CompetitionMessage> getlist(SearchTag searchTag) {
        //创建pb
        PageBean<CompetitionMessage> pb = new PageBean<>();
        //开始分页查询Pagehelper
        PageHelper.startPage(searchTag.getPageNum(), searchTag.getPageSize());
        //调用mapper
        List<CompetitionMessage> as = competitionMessageMapper.showlist(searchTag.getTitle(), searchTag.getOrganizer());
        //page中提供了方法，可以回去Pagehelper分页查询后，得到的总记录和当前页数据
        Page<CompetitionMessage> p=(Page<CompetitionMessage>) as;

        //把数据填会pb
        pb.setTotal((int)p.getTotal());
        pb.setProducts(p.getResult());
        return pb;
    }

    @Override
    public void toupdate(CompetitionMessage cm){
        competitionMessageMapper.toupdate(cm);
    }

    @Override
    public void delete(MID id){
        competitionMessageMapper.todelete(id);
    }

    @Override
    public CompetitionMessage findById(MID id){
        CompetitionMessage cm = competitionMessageMapper.findById(id);
        return cm;
    }
}
