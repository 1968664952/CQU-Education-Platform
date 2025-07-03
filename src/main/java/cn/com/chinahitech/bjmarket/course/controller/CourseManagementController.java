package cn.com.chinahitech.bjmarket.course.controller;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.course.Service.ChapterService;
import cn.com.chinahitech.bjmarket.course.Service.CourseManagementService;
import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public String uploadPathFile(MultipartFile uploadFile, HttpServletRequest req,String courseId, String title, int position) {
        Map<String,Object> result =new HashMap<String,Object>();
        String p= ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/video/";
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
//上传的文件名
        String oldName = uploadFile.getOriginalFilename();
//新的文件名
        String newName = courseId +"."+ position +
                oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
//将uploadFile存到一个路径为：folder，名字为：newName的文件，
            System.out.println(uploadFile.getSize());
            uploadFile.transferTo(new File(folder, newName));
//获取项目访问的路径
            filePath = req.getScheme() + "://" + req.getServerName() + ":" +
                    req.getServerPort() + "/video/" + format + newName;
            System.out.println(filePath);
            filePath="/video/" + format + newName;
            Chapter chapter=new Chapter();
            chapter.setCourseId(courseId);
            chapter.setTitle(title);
            chapter.setPosition(position);
            chapter.setUrl(filePath);
            System.out.println("!!!!!:"+chapter);
            int r= chapterService.addChapter(chapter);
            if (r==1){
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

    @PostMapping("/deleteChapter")
    public String deleteVideo(@RequestBody Chapter chapter) {
        Map<String, Object> result = new HashMap<>();

        try {
            // 1. 根据chapterId获取章节信息
            chapter = chapterService.queryOneChapter(chapter.getChapterId());
            if (chapter == null) {
                result.put("status", "404");
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
                result.put("msg", "视频删除成功");
            } else {
                result.put("status", "501");
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
            result.put("status", "500");
            result.put("msg", "系统异常: " + e.getMessage());
        }

        return JSON.toJSONString(result);
    }

}
