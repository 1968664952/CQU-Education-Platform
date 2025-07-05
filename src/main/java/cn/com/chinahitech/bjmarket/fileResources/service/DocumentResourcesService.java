package cn.com.chinahitech.bjmarket.fileResources.service;

import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.fileResources.entity.DocumentResources;
import cn.com.chinahitech.bjmarket.fileResources.entity.dayUpload;
import cn.com.chinahitech.bjmarket.fileResources.entity.drSearchTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 文档资源表 服务类
 * </p>
 *
 * @author zhufu
 * @since 2025-07-04
 */
public interface DocumentResourcesService extends IService<DocumentResources> {
    //管理员获取资源列表
    PageBean<DocumentResources> showlist(drSearchTag drSearchTag);
    //查看详细信息
    DocumentResources showdetail(int id);
    //设置资源状态
    int updatestatus(int status,int id);
    //删除对应id的资源
    int deleteById(int id);
    //上传资源信息
    int addDocumentResources(DocumentResources dr);
    //重设资源路径
    int updatefilepath(String filePath,int id);
    //增加浏览量和下载量
    int increaseView(int id);
    int increaseDownload(int id);
    //最近7天上传量
    List<dayUpload> recent7daySituation();
}
