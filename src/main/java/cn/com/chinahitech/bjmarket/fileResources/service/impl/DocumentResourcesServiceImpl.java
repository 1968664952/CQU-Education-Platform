package cn.com.chinahitech.bjmarket.fileResources.service.impl;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.fileResources.entity.DocumentResources;
import cn.com.chinahitech.bjmarket.fileResources.entity.dayUpload;
import cn.com.chinahitech.bjmarket.fileResources.entity.drSearchTag;
import cn.com.chinahitech.bjmarket.fileResources.mapper.DocumentResourcesMapper;
import cn.com.chinahitech.bjmarket.fileResources.service.DocumentResourcesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文档资源表 服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-04
 */
@Service
public class DocumentResourcesServiceImpl extends ServiceImpl<DocumentResourcesMapper, DocumentResources> implements DocumentResourcesService {
    @Autowired
    private DocumentResourcesMapper documentResourcesMapper;

    @Override
    public PageBean<DocumentResources> showlist(drSearchTag drSearchTag){
        PageBean<DocumentResources> drpb = new PageBean<>();
        PageHelper.startPage(drSearchTag.getPageNum(), drSearchTag.getPageSize());
        List<DocumentResources> drlist;
        String primaryCategory = drSearchTag.getPrimaryCategory();
        String secondaryCategory = drSearchTag.getSecondaryCategory();
        String year = drSearchTag.getUseyear();
        String applicableMajor = drSearchTag.getApplicableMajor();
        String applicableGrade = drSearchTag.getApplicableGrade();
        drlist=documentResourcesMapper.showlist(primaryCategory,secondaryCategory,year,applicableMajor,applicableGrade);
        Page<DocumentResources> drpage = (Page<DocumentResources>) drlist;

        drpb.setTotal((int)drpage.getTotal());
        drpb.setProducts(drpage.getResult());
        return drpb;
    }

    @Override
    public DocumentResources showdetail(int id){
        DocumentResources dr=documentResourcesMapper.getRes(id);
        return dr;
    }

    @Override
    public int updatestatus(int status, int id){
        int result = documentResourcesMapper.updatestatus(status,id);
        return result;
    }

    @Override
    public int deleteById(int id){
        int result = documentResourcesMapper.deleteById(id);
        return result;
    }

    @Override
    public int addDocumentResources(DocumentResources dr){
        int id = documentResourcesMapper.insertDocumentResource(dr);
        return id;
    }

    @Override
    public int updatefilepath(String filePath,int id){
        int result = documentResourcesMapper.updatefilepath(filePath,id);
        return  result;
    }

    @Override
    public int increaseView(int id){
        int result = documentResourcesMapper.increaseView(id);
        return result;
    }

    @Override
    public int increaseDownload(int id){
        int result = documentResourcesMapper.increaseDownload(id);
        return result;
    }

    @Override
    public List<dayUpload> recent7daySituation(){
        List<dayUpload> dayUploadslist=documentResourcesMapper.recent7daySituation();
        return dayUploadslist;
    }
}
