package cn.com.chinahitech.bjmarket.course.controller;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.course.Service.ChapterService;
import cn.com.chinahitech.bjmarket.course.Service.CourseManagementService;
import cn.com.chinahitech.bjmarket.course.Service.DailyCourseUploadService;
import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import cn.com.chinahitech.bjmarket.course.entity.DailyCourseUpload;
import cn.com.chinahitech.bjmarket.utils.VideoMetadataUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class CourseManagementController {
    @Autowired
    private CourseManagementService courseManagementService;

    @PostMapping("/addCourse")
    public Result<String> addCourse(@RequestBody Course course) {
        System.out.println(course);
        int result = courseManagementService.addCourse(course);
        return result > 0 ? Result.success("添加成功") : Result.error("添加失败");
    }

    @DeleteMapping("/deleteCourse")
    public Result<String> deleteCourse(@RequestBody Course course) {
        int result = courseManagementService.deleteCourse(course.getCourseId());
        return result > 0 ? Result.success("删除成功") : Result.error("删除失败");
    }

    @Autowired
    private ChapterService chapterService;

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
    @PostMapping("/uploadPahtFile")
    public String uploadPathFile(MultipartFile uploadFile,
                                 HttpServletRequest req,
                                 String courseId,
                                 String title,
                                 int position) {
        Map<String, Object> result = new HashMap<>();
        String basePath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/video/";
        System.out.println("视频存储根路径: " + basePath);

        // 1. 检查文件是否为空
        if (uploadFile.isEmpty()) {
            result.put("status", "400");
            result.put("msg", "上传文件不能为空");
            return JSON.toJSONString(result);
        }

        // 2. 准备存储目录（按日期分类）
        String dateFolder = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        File folder = new File(basePath + dateFolder);
        if (!folder.exists()) {
            folder.mkdirs(); // 创建多级目录
        }

        // 3. 生成唯一文件名（避免冲突）
        String originalFilename = uploadFile.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newName = courseId + "." + position + fileExtension; // 格式：courseId.position.扩展名

        try {
            // 4. 保存文件到本地
            File targetFile = new File(folder, newName);
            uploadFile.transferTo(targetFile);
            System.out.println("文件已保存至: " + targetFile.getAbsolutePath());

            // 5. 获取视频元数据（时长、分辨率）
            String localFilePath = targetFile.getAbsolutePath(); // 本地物理路径
            double duration = VideoMetadataUtil.getDuration(localFilePath); // 时长（秒）

            // 6. 构建访问URL（前端可访问的路径）
            String filePath = "/video/" + dateFolder + "/" + newName;
            String fullUrl = req.getScheme() + "://" + req.getServerName() + ":" +
                    req.getServerPort() + filePath;

            // 7. 创建章节对象并设置元数据
            Chapter chapter = new Chapter();
            chapter.setCourseId(courseId);
            chapter.setTitle(title);
            chapter.setPosition(position);
            chapter.setUrl(filePath);
            chapter.setDuration(duration); // 设置时长（关键！）

            // 8. 插入数据库
            int insertResult = chapterService.addChapter(chapter);
            if (insertResult > 0) {
                result.put("status", "200");
                result.put("msg", "视频上传成功");
                result.put("chapterId", chapter.getChapterId()); // 返回生成的章节ID
            } else {
                result.put("status", "500");
                result.put("msg", "数据库插入失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
            result.put("status", "501");
            result.put("msg", "文件保存失败: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "502");
            result.put("msg", "系统异常: " + e.getMessage());
        }

        return JSON.toJSONString(result);
    }


    @PostMapping("/deleteChapter")
    public String deleteVideo(@RequestBody Chapter chapter) {
        Map<String, Object> result = new HashMap<>();

        try {
            // 1. 根据chapterId获取章节信息
            chapter = chapterService.queryOneChapter(chapter.getChapterId());
            if (chapter == null) {
                result.put("status", "500");
                result.put("msg", "章节记录不存在");
                return JSON.toJSONString(result);
            }

            // 2. 获取视频文件路径
            String filePath = chapter.getUrl();
            if (filePath == null || filePath.isEmpty()) {
                result.put("status", "500");
                result.put("msg", "视频路径信息缺失");
                return JSON.toJSONString(result);
            }

            // 3. 构建物理文件路径
            String basePath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static";
            File videoFile = new File(basePath + filePath);

            // 4. 打印调试信息
            System.out.println("尝试删除视频: " + videoFile.getAbsolutePath());
            System.out.println("数据库记录: " + chapter);

            // 5. 删除文件系统视频
            boolean fileDeleted = false;
            if (videoFile.exists()) {
                fileDeleted = videoFile.delete();
                System.out.println("文件删除结果: " + (fileDeleted ? "成功" : "失败"));
            } else {
                System.out.println("警告: 文件不存在，可能是已删除或路径错误");
                // 即使文件不存在，也继续删除数据库记录
                fileDeleted = true;
            }

            // 6. 删除数据库章节记录
            int dbResult = chapterService.delChapter(chapter.getChapterId());
            System.out.println("数据库删除结果: " + dbResult);

            // 7. 构建响应
            if (fileDeleted && dbResult > 0) {
                result.put("status", "200");
                result.put("msg", "视频删除成功！");
            } else {
                result.put("status", "500");
                result.put("msg", "部分删除失败");

                if (!fileDeleted) {
                    result.put("fileError", "视频文件删除失败，路径: " + videoFile.getAbsolutePath());
                }
                if (dbResult == 0) {
                    result.put("dbError", "数据库删除失败，chapterId: " + chapter.getCourseId());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "501");
            result.put("msg", "系统异常: " + e.getMessage());
        }

        return JSON.toJSONString(result);
    }

    @Autowired
    private DailyCourseUploadService dailyCourseUploadService;

    @RequestMapping(value="/dailyCourseUpload",method = RequestMethod.GET)
    public String dailyCourseUpload(){
        List<DailyCourseUpload> dailyCourseUploadList =null;
        Map<String,Object> result =new HashMap<String,Object>();
        try{
            dailyCourseUploadList=dailyCourseUploadService.queryUpload();

            result.put("status","200");
            result.put("msg","检索成功！");
            result.put("data",dailyCourseUploadList);

        }catch(Exception ex){
            ex.printStackTrace();
            result.put("status","501");
            result.put("msg","异常："+ex.getMessage());
        }
        return JSON.toJSONString(result);
    }

}
