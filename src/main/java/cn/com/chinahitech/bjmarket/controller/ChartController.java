package cn.com.chinahitech.bjmarket.controller;

import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/chart")
public class ChartController {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
    @PostMapping("/uploadPahtFile")
    public String uploadPathFile(MultipartFile uploadFile, HttpServletRequest
            req) {
        String
                p=ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static\\video";
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
        String newName = UUID.randomUUID().toString() +
                oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
//将uploadFile存到一个路径为：folder，名字为：newName的文件，
            System.out.println(uploadFile.getSize());
            uploadFile.transferTo(new File(folder, newName));

//获取项目访问的路径
            filePath = req.getScheme() + "://" + req.getServerName() + ":" +
                    req.getServerPort() + "/video" + format + newName;
            System.out.println(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败! ";
        }
        return filePath;
    }
}