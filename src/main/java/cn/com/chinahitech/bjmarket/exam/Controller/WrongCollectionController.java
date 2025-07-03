package cn.com.chinahitech.bjmarket.exam.Controller;

import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.exam.DTO.StudentDTO;
import cn.com.chinahitech.bjmarket.exam.Service.WrongCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exam/paper/question")
public class WrongCollectionController {

    @Autowired
    private WrongCollectionService wrongCollectionService;

    /**
     * 根据学生ID查询错题本
     * @param student 学生ID
     * @return 包含选择题、判断题、填空题、简答题的错题数据
     */
    @PostMapping("/wrong")
    public Result<Map<String, List<Object>>> getWrongByStudentId(@RequestBody StudentDTO student) {
        try {
            Map<String, List<Object>> result = wrongCollectionService.getWrongQuestionsByStudentId(student.getStudentId());
            if (result == null || result.values().stream().allMatch(List::isEmpty)) {
                return Result.error("该学生暂无错题记录");
            }
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("查询错题失败：" + e.getMessage());
        }
    }
}
