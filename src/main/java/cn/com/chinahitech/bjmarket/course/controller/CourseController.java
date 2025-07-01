package cn.com.chinahitech.bjmarket.course.controller;

import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.course.DTO.CID;
import cn.com.chinahitech.bjmarket.course.DTO.CourseRequestDTO;
import cn.com.chinahitech.bjmarket.course.DTO.Keyword;
import cn.com.chinahitech.bjmarket.course.Service.ChapterService;
import cn.com.chinahitech.bjmarket.course.Service.CourseService;
import cn.com.chinahitech.bjmarket.course.Service.CourserankService;
import cn.com.chinahitech.bjmarket.course.Service.FavoriteService;
import cn.com.chinahitech.bjmarket.course.entity.Chapter;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import cn.com.chinahitech.bjmarket.course.entity.Favorite;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value="/queryByKeyword",method = RequestMethod.POST)
    public String queryByKeyword(@RequestBody Keyword keyword){
        List<Course> courseList =null;
        Map<String,Object> result =new HashMap<String,Object>();
        try{
            courseList=courseService.queryCourseByKeyword(keyword.getKeyword());
            if(courseList.size()>0){
                result.put("status","200");
                result.put("msg","检索成功！");
                result.put("data",courseList);
            }else {
                result.put("status","500");
                result.put("msg","该课程不存在");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            result.put("status","501");
            result.put("msg","异常："+ex.getMessage());
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(value="/queryPGCourse",method = RequestMethod.GET)
    public String queryPGCourse(){
        List<Course> courseList =null;
        Map<String,Object> result =new HashMap<String,Object>();
        try{
            courseList=courseService.queryPGCourse();
            if(courseList.size()>0){
                result.put("status","200");
                result.put("msg","检索成功！");
                result.put("data",courseList);
            }else {
                result.put("status","500");
                result.put("msg","该课程不存在");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            result.put("status","501");
            result.put("msg","异常："+ex.getMessage());
        }
        return JSON.toJSONString(result);
    }

    //

    @Autowired
    private ChapterService chapterService;

    @RequestMapping(value="/queryChapterById",method = RequestMethod.POST)
    public String queryChapterById(@RequestBody CID cid){
        List<Chapter> chapterList =null;
        Map<String,Object> result =new HashMap<String,Object>();
        try{
            chapterList=chapterService.queryChapterById(cid.getCourse_id());
            if(chapterList.size()>0){
                result.put("status","200");
                result.put("msg","检索成功！");
                result.put("data",chapterList);
            }else {
                result.put("status","500");
                result.put("msg","错误！未检索到");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            result.put("status","501");
            result.put("msg","异常："+ex.getMessage());
        }
        return JSON.toJSONString(result);
    }

    //
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/addFavorite",method = RequestMethod.POST)
    public String addFavorite(@RequestBody CID cid){
        Map<String,Object> map =new HashMap<String,Object>();
        Favorite favorite=new Favorite();
        favorite.setCourseId(cid.getCourse_id());
        favorite.setStudentId((String) request.getSession().getAttribute("studentId"));
        try{
            int result=favoriteService.addFavorite(favorite);
            if(result==1){
                map.put("status","200");
                map.put("msg","收藏成功！");
            }else {
                map.put("status","500");
                map.put("msg","收藏失败！");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            map.put("status","501");
            map.put("msg","异常："+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

    //

    @Autowired
    private CourserankService courserankService;

    @PostMapping("/rank")
    public Result<List<Course>> getCourseRank(@RequestBody CourseRequestDTO dto) {
        List<Course> courseList = courserankService.getTopCoursesByCourseBankId(dto.getCBankId(), dto.getLimit());
        return Result.success(courseList);
}
}

//  http://localhost:8081/course/addFavorite