package cn.com.chinahitech.bjmarket.information.teaching_activities.controller;


import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.entity.SearchTag;
import cn.com.chinahitech.bjmarket.information.teaching_activities.entity.TeachingActivities;
import cn.com.chinahitech.bjmarket.information.teaching_activities.service.TeachingActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 教学活动信息表 前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
@RestController
@RequestMapping("/admin/teaching_activities")
public class AdminTeachingActivitiesController {
    @Autowired
    private TeachingActivitiesService teachingActivitiesService;

    @PostMapping("/post")
    public Result<?> add(@RequestBody TeachingActivities new1) {
        teachingActivitiesService.add(new1);
        return Result.success(null);
    }

    @GetMapping("/list")
    public Result<PageBean<TeachingActivities>> list(@RequestBody SearchTag searchTag){
        PageBean<TeachingActivities> pb =teachingActivitiesService.getlist(searchTag);
        return Result.success(pb);
    }

    @GetMapping("/detail")
    public Result<TeachingActivities> list(@RequestBody MID id){
        TeachingActivities ta = teachingActivitiesService.findById(id);
        return Result.success(ta);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody @Validated TeachingActivities activities){
        teachingActivitiesService.toupdate(activities);
        return Result.success(null);
    }

    @DeleteMapping("delete")
    public  Result<?> delete(MID id){
        teachingActivitiesService.delete(id);
        return Result.success(null);
    }
}
