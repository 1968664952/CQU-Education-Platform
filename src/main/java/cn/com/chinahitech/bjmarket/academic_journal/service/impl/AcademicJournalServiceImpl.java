package cn.com.chinahitech.bjmarket.academic_journal.service.impl;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.academic_journal.entity.AcademicJournal;
import cn.com.chinahitech.bjmarket.academic_journal.mapper.AcademicJournalMapper;
import cn.com.chinahitech.bjmarket.academic_journal.service.AcademicJournalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 学术期刊信息表 服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2025-06-30
 */
@Service
public class AcademicJournalServiceImpl extends ServiceImpl<AcademicJournalMapper, AcademicJournal> implements AcademicJournalService {
    @Autowired
    private AcademicJournalMapper academicJournalMapper;

    @Override
    public void add(@RequestBody AcademicJournal new1) {
        //补充属性值
        academicJournalMapper.add(new1);
    }

    @Override
    public PageBean<AcademicJournal> getlist(Integer pageNum, Integer pageSize, String title,String publisher) {
        //创建pb
        PageBean<AcademicJournal> pb = new PageBean<>();
        //开始分页查询Pagehelper
        PageHelper.startPage(pageNum, pageSize);
        //调用mapper
        List<AcademicJournal> as = academicJournalMapper.showlist(title,publisher);
        //page中提供了方法，可以回去Pagehelper分页查询后，得到的总记录和当前页数据
        Page<AcademicJournal> p=(Page<AcademicJournal>) as;

        //把数据填会pb
        pb.setTotal((int)p.getTotal());
        pb.setProducts(p.getResult());
        return pb;
    }

    @Override
    public void toupdate(AcademicJournal journal){
        academicJournalMapper.toupdate(journal);
    }

    @Override
    public void delete(int id){
        academicJournalMapper.todelete(id);
    }

    @Override
    public AcademicJournal findById(Integer id){
        AcademicJournal aj = academicJournalMapper.findById(id);
        return aj;
    }
}
