package cn.com.chinahitech.bjmarket.exam.Controller;

import cn.com.chinahitech.bjmarket.common.Result;

import cn.com.chinahitech.bjmarket.exam.DTO.QBankRequestDTO;
import cn.com.chinahitech.bjmarket.exam.Entity.TestPaper;
import cn.com.chinahitech.bjmarket.exam.Mapper.TestPaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/exam")
public class TestPaperController {

    @Autowired
    private TestPaperMapper testPaperMapper;

    @PostMapping("/paper")
    public Result<List<TestPaper>> getByQBankId(@RequestBody QBankRequestDTO request) {
        try {
            List<TestPaper> papers = testPaperMapper.getByQBankId(request.getQBankId());
            if (papers == null || papers.isEmpty()) {
                return Result.error("该题库下无试卷");
            }
            return Result.success(papers);
        } catch (Exception e) {
            return Result.error("查询试卷失败：" + e.getMessage());
        }
    }

}
