package cn.com.chinahitech.bjmarket.exam.Controller;

import cn.com.chinahitech.bjmarket.common.Result;

import cn.com.chinahitech.bjmarket.exam.DTO.QBankRequestDTO;
import cn.com.chinahitech.bjmarket.exam.Entity.TestPaper;
import cn.com.chinahitech.bjmarket.exam.Mapper.TestPaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/exam/paper")
public class TestPaperController {

    @Autowired
    private TestPaperMapper testPaperMapper;

    @PostMapping("/byQBankId")
    public Result<List<TestPaper>> getByQBankId(@RequestBody QBankRequestDTO request) {
        List<TestPaper> papers = testPaperMapper.getByQBankId(request.getQBankId());
        return Result.success(papers);
    }
}
