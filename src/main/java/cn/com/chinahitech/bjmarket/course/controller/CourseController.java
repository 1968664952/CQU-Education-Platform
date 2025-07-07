package cn.com.chinahitech.bjmarket.course.controller;

import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.course.DTO.CID;
import cn.com.chinahitech.bjmarket.course.DTO.CourseLibrary;
import cn.com.chinahitech.bjmarket.course.DTO.CourseRequestDTO;
import cn.com.chinahitech.bjmarket.course.DTO.Keyword;
import cn.com.chinahitech.bjmarket.course.Service.*;
import cn.com.chinahitech.bjmarket.course.entity.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseKuService courseKuService;
    @Autowired
    private CourseScoreService courseScoreService;

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

    @RequestMapping(value="/courseList",method = RequestMethod.POST)
    public String courseList(@RequestBody CourseLibrary courseLibrary){
        List<Course> courseList =null;
        Map<String,Object> result =new HashMap<String,Object>();
        try{
            courseList=courseService.courseList(courseLibrary.getCBankId(),courseLibrary.getGrade(),courseLibrary.getNewOrHot());
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

    @RequestMapping(value="/personalRecom",method = RequestMethod.GET)
    public String personalRecom(){
        List<Course> courseList =null;
        List<Course> courseList0 =null;
        List<CourseScores> courseScoresList=null;
        Map<String,Object> result =new HashMap<String,Object>();
        int grade=(int)request.getSession().getAttribute("grade");
        int cBankId=0;
        try {
            String major=(String) request.getSession().getAttribute("majorName");
            cBankId=courseKuService.queryIdBymajor(major);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.put("status","501");
            result.put("msg","异常："+ex.getMessage());
        }
        if(grade==4) {
            try {
                courseList = courseService.queryPGCourse();
            } catch (Exception ex) {
                ex.printStackTrace();
                result.put("status","501");
                result.put("msg","异常："+ex.getMessage());
            }
        }

        String studentId=(String) request.getSession().getAttribute("studentId");
        try{
            courseScoresList=courseScoreService.queryLearnedCourse(studentId);
            List<String> courseNames = courseScoresList.stream()
                    .map(CourseScores::getCourseName)
                    .collect(Collectors.toList());
            courseList0=courseService.personalRecom1(courseNames,cBankId,grade);
            courseList.addAll(courseList0);
            if (courseList.size()>10){
                courseList.subList(10, courseList.size()).clear();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            result.put("status","501");
            result.put("msg","异常："+ex.getMessage());
        }

        int size=courseList.size();
        if (size<10){
            try {
                courseList0=courseService.personalRecom2(cBankId,grade);
                courseList = Stream.concat(courseList.stream(), courseList0.stream())
                        .limit(10)
                        .distinct() // 基于Course的equals方法去重，需要正确实现equals/hashCode
                        .collect(Collectors.toList());
                size=courseList.size();
                if (size>10){
                    courseList.subList(10, courseList.size()).clear();
                    System.out.println(courseList.size());
                }
                else if (size<10){
                    courseList0=courseService.personalRecom3(cBankId);
                    courseList = Stream.concat(courseList.stream(), courseList0.stream())
                            .limit(10)
                            .distinct() // 基于Course的equals方法去重，需要正确实现equals/hashCode
                            .collect(Collectors.toList());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                result.put("status","501");
                result.put("msg","异常："+ex.getMessage());
            }
        }else if (size>10){
            courseList.subList(10, courseList.size()).clear();
        }
        result.put("status","200");
        result.put("msg","检索成功！");
        result.put("data",courseList);


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

    @RequestMapping(value = "/addFavorite",method = RequestMethod.POST)
    public String addFavorite(@RequestBody CID cid){
        Map<String,Object> map =new HashMap<String,Object>();
        Favorite favorite=new Favorite();
        favorite.setCourseId(cid.getCourse_id());
        favorite.setStudentId((String) request.getSession().getAttribute("studentId"));
        try{
            int result=favoriteService.addFavorite(favorite);
            int f=courseService.addFavoriteCount(cid.getCourse_id());
            if(result==1&&f==1){
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

    @RequestMapping(value="/queryFavoriteById",method = RequestMethod.POST)
    public String queryFavoriteById(@RequestBody CID cid){
        List<Favorite> favoriteList =null;
        Map<String,Object> result =new HashMap<String,Object>();
        try{
            favoriteList=favoriteService.queryFavoriteById(cid.getCourse_id(),(String) request.getSession().getAttribute("studentId"));
            if(favoriteList.size()==1){
                result.put("status","200");
                result.put("msg","已收藏");
            }else {
                result.put("status","500");
                result.put("msg","未收藏");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            result.put("status","501");
            result.put("msg","异常："+ex.getMessage());
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(value="/deleteFavorite",method = RequestMethod.POST)
    public String deleteFavorite(@RequestBody CID cid){
        Map<String,Object> map =new HashMap<String,Object>();
        try{
            int result=favoriteService.deleteFavorite(cid.getCourse_id(),(String) request.getSession().getAttribute("studentId"));
            int f=courseService.delFavoriteCount(cid.getCourse_id());
            if(result==1&&f==1){
                map.put("status","200");
                map.put("msg","删除成功！");
            }else {
                map.put("status","500");
                map.put("msg","删除失败！");
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
    private VideoPlaybackHistoryService videoPlaybackHistoryService;

    @PostMapping("/saveOrUpdateHistory")
    public String saveProgress(@RequestBody VideoPlaybackHistory videoPlaybackHistory) {
        String studentId=(String)request.getSession().getAttribute("studentId");
        int chapterId=videoPlaybackHistory.getChapterId();
        int position=videoPlaybackHistory.getPosition();
        int lastPosition=videoPlaybackHistory.getLastPosition();
        Map<String,Object> map =new HashMap<String,Object>();
        try{
            int result=videoPlaybackHistoryService.saveOrUpdateHistory(studentId,chapterId,position,lastPosition);
            if(result==1){
                map.put("status","200");
                map.put("msg","添加成功！");
            }else {
                map.put("status","500");
                map.put("msg","添加失败！");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            map.put("status","501");
            map.put("msg","异常："+ex.getMessage());
        }
        return JSON.toJSONString(map);

    }

    @PostMapping("/getLastPosition")
    public String getLastPosition(@RequestBody VideoPlaybackHistory videoPlaybackHistory) {
        String studentId=(String)request.getSession().getAttribute("studentId");
        int chapterId=videoPlaybackHistory.getChapterId();
        int position=videoPlaybackHistory.getPosition();

        Map<String,Object> map =new HashMap<String,Object>();
        try{
            int result=0;
            result=videoPlaybackHistoryService.getLastPosition(studentId,chapterId,position);
            if(result==-1){
                map.put("status","500");
                map.put("msg","没有浏览记录");
            }else {
                map.put("status","200");
                map.put("msg","搜索成功！");
                map.put("data",result);
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

//  http://localhost:8081/course/courseList