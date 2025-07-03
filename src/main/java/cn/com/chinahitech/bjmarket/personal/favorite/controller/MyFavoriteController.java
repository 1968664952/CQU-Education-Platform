package cn.com.chinahitech.bjmarket.personal.favorite.controller;


import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import cn.com.chinahitech.bjmarket.personal.favorite.service.MyFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程收藏表 前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2025-07-02
 */
@RestController
@CrossOrigin
@RequestMapping("/personal_feild")
public class MyFavoriteController {
    @Autowired
    private MyFavoriteService myFavoriteService;

    @PostMapping("/{studentid}/favoriteCourses")
    public Result<PageBean<Course>> getFavoriteCourses(
            @PathVariable String studentid,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        // 参数验证
        if (page < 1) {
            return Result.error(null);
        }
        if (size < 1 || size > 100) {
            return Result.error(null);
        }

        // 获取分页结果
        PageBean<Course> res = myFavoriteService.getFavoriteCoursesPage(studentid, page, size);

        // 返回成功响应
        if(res!=null) {
            return Result.success(res);
        }
        else{
            return Result.error(null);
        }
    }
}
