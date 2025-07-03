package cn.com.chinahitech.bjmarket.personal.course_scores.controller;


import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.personal.course_scores.entity.CourseScoreData;
import cn.com.chinahitech.bjmarket.personal.course_scores.entity.MyCourseScores;
import cn.com.chinahitech.bjmarket.personal.course_scores.service.MyCourseScoresService;
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
@CrossOrigin
@RequestMapping("/personal_feild")
public class MyCourseScoresController {
    @Autowired
    private MyCourseScoresService myCourseScoresService;

    @GetMapping("/{studentid}/getCourseScores")
    public Result<List<CourseScoreData>> getAll(@PathVariable String studentid){
        List<CourseScoreData> cs = myCourseScoresService.getAll(studentid);
        if(!cs.isEmpty()){
            return Result.success(cs);
        }
        else{
            return  Result.error(null);
        }
    }
}
