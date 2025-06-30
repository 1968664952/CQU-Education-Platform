package cn.com.chinahitech.bjmarket.course.controller;

import cn.com.chinahitech.bjmarket.course.DTO.Keyword;
import cn.com.chinahitech.bjmarket.course.Service.CourseService;
import cn.com.chinahitech.bjmarket.course.entity.Course;
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

}
//  http://localhost:8081/course/queryByKeyword