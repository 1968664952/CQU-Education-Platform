package cn.com.chinahitech.bjmarket.exam.Controller;

import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.exam.DTO.StudentDTO;
import cn.com.chinahitech.bjmarket.exam.DTO.WrongCollectionDTO;
import cn.com.chinahitech.bjmarket.exam.Service.WrongCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wrongCollection")
public class WrongCollectionController {

    @Autowired
    private WrongCollectionService wrongCollectionService;
    @PostMapping("/get")
    public Result<Map<String, List<Map<String, Object>>>> getWrongByStudentId(@RequestBody StudentDTO student) {
        try {
            Map<String, List<Map<String, Object>>> result = wrongCollectionService.getWrongQuestionsByStudentId(student.getStudentId());
            if (result == null || result.values().stream().allMatch(List::isEmpty)) {
                return Result.error("该学生暂无错题记录");
            }
            return Result.success(result);
        } catch (Exception e) {
            return Result.error("查询错题失败：" + e.getMessage());
        }
    }
    @PostMapping("/add")
    public Result<String> addWrongCollection(@RequestBody WrongCollectionDTO dto) {
        try {
            String message = wrongCollectionService.addWrong(dto);
            if ("插入成功".equals(message)) {
                return Result.success(message);
            } else {
                return Result.error(message);
            }
        } catch (Exception e) {
            return Result.error("插入失败：" + e.getMessage());
        }
    }
}
