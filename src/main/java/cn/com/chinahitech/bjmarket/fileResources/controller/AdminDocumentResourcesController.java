package cn.com.chinahitech.bjmarket.fileResources.controller;


import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import cn.com.chinahitech.bjmarket.fileResources.entity.DocumentResources;
import cn.com.chinahitech.bjmarket.fileResources.entity.dayUpload;
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
import java.util.List;
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
        DocumentResources dr=documentResourcesService.showdetail(id);
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

    @PostMapping("/deleteDocRes")
    public String deleteVideo(@RequestBody DocumentResources dr) {
        Map<String, Object> result = new HashMap<>();

        try {
            // 1. 根据chapterId获取章节信息
            dr = documentResourcesService.showdetail(dr.getId());
            if (dr == null) {
                result.put("status", "500");
                result.put("msg", "章节记录不存在");
                return JSON.toJSONString(result);
            }

            // 2. 获取视频文件路径
            String filePath = dr.getFilePath();
            if (filePath == null || filePath.isEmpty()) {
                result.put("status", "500");
                result.put("msg", "视频路径信息缺失");
                return JSON.toJSONString(result);
            }

            // 3. 构建物理文件路径
            String basePath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static";
            File docFile = new File(basePath + filePath);

            // 4. 打印调试信息
            System.out.println("尝试删除资源: " + docFile.getAbsolutePath());
            System.out.println("数据库记录: " + dr);

            // 5. 删除文件系统视频
            boolean fileDeleted = false;
            if (docFile.exists()) {
                fileDeleted = docFile.delete();
                System.out.println("文件删除结果: " + (fileDeleted ? "成功" : "失败"));
            } else {
                System.out.println("警告: 文件不存在，可能是已删除或路径错误");
                // 即使文件不存在，也继续删除数据库记录
                fileDeleted = true;
            }

            // 6. 删除数据库章节记录
            int dbResult = documentResourcesService.deleteById(dr.getId());
            System.out.println("数据库删除结果: " + dbResult);

            // 7. 构建响应
            if (fileDeleted && dbResult > 0) {
                result.put("status", "200");
                result.put("msg", "视频删除成功！");
            } else {
                result.put("status", "500");
                result.put("msg", "部分删除失败");

                if (!fileDeleted) {
                    result.put("fileError", "视频文件删除失败，路径: " + docFile.getAbsolutePath());
                }
                if (dbResult == 0) {
                    result.put("dbError", "数据库删除失败，Id: " + dr.getId());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "501");
            result.put("msg", "系统异常: " + e.getMessage());
        }

        return JSON.toJSONString(result);
    }

    @PostMapping("/recent7day")
    public Result<List<dayUpload>> recent7day() {
        List<dayUpload> dayUploads=documentResourcesService.recent7daySituation();
        return Result.success(dayUploads);
    }

}
