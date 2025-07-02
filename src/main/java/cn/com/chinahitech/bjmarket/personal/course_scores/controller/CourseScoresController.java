package cn.com.chinahitech.bjmarket.personal.course_scores.controller;


import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.personal.course_scores.entity.CourseScores;
import cn.com.chinahitech.bjmarket.personal.course_scores.service.CourseScoresService;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 学生选课得分表 前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2025-07-02
 */
@RestController
@RequestMapping("/personal_feild")
public class CourseScoresController {
    @Autowired
    private CourseScoresService courseScoresService;

    @GetMapping("/{student}/getCourseScores")
    public Result<List<CourseScores>> getAll(@PathVariable String studentid){
        List<CourseScores> cs = courseScoresService.getAll(studentid);
        if(!cs.isEmpty()){
            return Result.success(cs);
        }
        else{
            return  Result.error(null);
        }
    }
}
