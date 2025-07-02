package cn.com.chinahitech.bjmarket.exam.Controller;

import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.exam.DTO.QuestionBankQueryDTO;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionBank;
import cn.com.chinahitech.bjmarket.exam.Service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/exam")
public class QuestionBankController {

    @Autowired
    private QuestionBankService service;

    // 查询全部题库
    @PostMapping("/all")
    public Result<List<QuestionBank>> getAll() {
        try {
            List<QuestionBank> list = service.getAll();
            if (list == null || list.isEmpty()) {
                return Result.error("题库为空");
            }
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    // 根据分类查询
    @PostMapping("/by-category")
    public Result<List<QuestionBank>> getByCategory(@RequestBody QuestionBankQueryDTO dto) {
        try {
            List<QuestionBank> list = service.getByCategory(dto.getCategory());
            if (list == null || list.isEmpty()) {
                return Result.error("该分类下无题库");
            }
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }

    // 根据关键词搜索（全文索引）
    @PostMapping("/search")
    public Result<List<QuestionBank>> searchByKeyword(@RequestBody QuestionBankQueryDTO dto) {
        try {
            List<QuestionBank> list = service.search(dto.getKeyword());
            if (list == null || list.isEmpty()) {
                return Result.error("未找到匹配的题库");
            }
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("搜索失败：" + e.getMessage());
        }
    }

    // 按时间排序返回所有
    @PostMapping("/sorted")
    public Result<List<QuestionBank>> getSorted() {
        try {
            List<QuestionBank> list = service.getSortedByCreatedAt();
            if (list == null || list.isEmpty()) {
                return Result.error("题库为空");
            }
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("查询失败：" + e.getMessage());
        }
    }
}

