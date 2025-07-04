package cn.com.chinahitech.bjmarket.fileResources.controller;


import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import cn.com.chinahitech.bjmarket.fileResources.entity.DocumentResources;
import cn.com.chinahitech.bjmarket.fileResources.entity.drSearchTag;
import cn.com.chinahitech.bjmarket.fileResources.service.DocumentResourcesService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 文档资源表 前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2025-07-04
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/document-resources")
public class AdminDocumentResourcesController {
    @Autowired
    private DocumentResourcesService documentResourcesService;

    @PostMapping("/getList")
    public Result<PageBean<DocumentResources>> getList(@RequestBody drSearchTag drSearchTag){
        PageBean<DocumentResources> pb=documentResourcesService.showlist(drSearchTag);
        return Result.success(pb);
    }

    @PostMapping("/getDetail")
    public Result<DocumentResources> getDetail(int id){
        DocumentResources dr=documentResourcesService.getById(id);
        if(dr!=null){
            return Result.success(dr);
        }
        else {
            return Result.error(null);
        }
    }

    @PostMapping("/setStatus")
    public Result<?> update(int status,int id){
        int result = documentResourcesService.updatestatus(status,id);
        if(result==1){
            return Result.success(null);
        }
        else{
            return Result.error(null);
        }
    }

    @DeleteMapping("/delete")
    public Result<?> delete(int id){
        int result = documentResourcesService.deleteById(id);
        if(result==1){
            return Result.success(null);
        }
        else{
            return Result.error(null);
        }
    }

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
    @PostMapping("/uploadPathFile")
    public String uploadPathFile(MultipartFile uploadFile, HttpServletRequest req, String title,String primaryCategory,String secondaryCategory,String useyear,String authorId,String authorName,String applicableMajor,String applicableGrade) {
        Map<String,Object> result =new HashMap<String,Object>();
        String p= ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/documentResources/";
        System.out.println(p);
        if ("".equals(uploadFile.getOriginalFilename())){
            return "";
        }
        String filePath = "";
        String format = sdf.format(new Date());
//固定物理路径
        File folder = new File(p + format);
//如果文件夹不存在则创建
        if (!folder.exists()) {
            folder.mkdirs();//创建文件夹
        }
        DocumentResources dr=new DocumentResources();
        dr.setTitle(title);
        dr.setPrimaryCategory(primaryCategory);
        dr.setSecondaryCategory(secondaryCategory);
        dr.setUseyear(useyear);
        dr.setViewCount(0);
        dr.setDownloadCount(0);
        dr.setPublishTime(LocalDateTime.now());
        dr.setAuthorId(authorId);
        dr.setAuthorName(authorName);
        dr.setStatus(false);
        dr.setApplicableMajor(applicableMajor);
        dr.setApplicableGrade(applicableGrade);
        dr.setFilePath("321");
        documentResourcesService.addDocumentResources(dr);

        int id = dr.getId();

//上传的文件名
        String oldName = uploadFile.getOriginalFilename();
//新的文件名
        String newName = dr.getAuthorId()+"."+ id +
                oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
//将uploadFile存到一个路径为：folder，名字为：newName的文件，
            System.out.println(uploadFile.getSize());
            uploadFile.transferTo(new File(folder, newName));
//获取项目访问的路径
            filePath = req.getScheme() + "://" + req.getServerName() + ":" +
                    req.getServerPort() + "/documentResources/" + format + newName;
            System.out.println(filePath);
            filePath="/documentResources/" + format + newName;
            documentResourcesService.updatefilepath(filePath,id);
            System.out.println("!!!!!:"+dr);
            if (id!=0){
                result.put("status","200");
                result.put("msg","上传成功！");
            }else {
                result.put("status", "500");
                result.put("msg", "上传数据库存在问题");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            result.put("status","501");
            result.put("msg","异常："+ex.getMessage());
        }
        return JSON.toJSONString(result);
    }

}
