package cn.com.chinahitech.bjmarket.personal.course_scores.controller;


import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.personal.course_scores.entity.*;
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

    @PostMapping("/{studentid}/getCourseScores")
    public Result<List<CourseScoreData>> getAll(@PathVariable String studentid){
        List<CourseScoreData> cs = myCourseScoresService.getAll(studentid);
        if(!cs.isEmpty()){
            return Result.success(cs);
        }
        else{
            return  Result.error(null);
        }
    }

    @PostMapping("/{studentId}/getGPA")
    public Result<GPAInfo> getStudentGPA(@PathVariable String studentId) {
        GPAInfo gpa=myCourseScoresService.calculateGPA(studentId);
        if(gpa.getGpa()!=0.0){
            return Result.success(gpa);
        }
        else{
            return  Result.error(null);
        }
    }

    @PostMapping("/{studentId}/getCreditSummary")
    public Result<Credit> getStudentCreditSummary(@PathVariable String studentId) {
        Credit cd = myCourseScoresService.getCreditSummary(studentId);
        if(cd!=null){
            return Result.success(cd);
        }
        else{
            return  Result.error(null);
        }
    }

    @PostMapping("/{studentId}/getCourseCount")
    public Result<CourseCount> getStudentCourseCount(@PathVariable String studentId) {
        CourseCount cc = myCourseScoresService.getCourseCounts(studentId);
        if(cc.getEcount()!=0.0&&cc.getEcount()!=0.0){
            return Result.success(cc);
        }
        else{
            return  Result.error(null);
        }
    }
}
