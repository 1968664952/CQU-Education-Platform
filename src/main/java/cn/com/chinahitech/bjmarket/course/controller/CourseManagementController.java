package cn.com.chinahitech.bjmarket.course.controller;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.course.Service.CourseManagementService;
import cn.com.chinahitech.bjmarket.course.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/coursemanagement")
public class CourseManagementController {
    @Autowired
    private CourseManagementService courseManagementService;

    @PostMapping
    public Result<String> addCourse(@RequestBody Course course) {
        int result = courseManagementService.addCourse(course);
        return result > 0 ? Result.success("添加成功") : Result.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteCourse(@PathVariable("id") Integer id) {
        int result = courseManagementService.deleteCourse(id);
        return result > 0 ? Result.success("删除成功") : Result.error("删除失败");
    }

}
