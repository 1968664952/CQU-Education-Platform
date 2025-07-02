package cn.com.chinahitech.bjmarket.exam.Controller;
import cn.com.chinahitech.bjmarket.common.Result;

import cn.com.chinahitech.bjmarket.exam.DTO.PaperRequestDTO;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionBlank;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionSelect;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionShortAnswer;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionTF;
import cn.com.chinahitech.bjmarket.exam.Mapper.GetQuestionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/paper")
public class GetQuestionController {

    @Autowired
    private GetQuestionMapper getquestionMapper;

    @PostMapping("/blank")
    public Result<List<QuestionBlank>> getQuestionBlank(@RequestBody PaperRequestDTO request) {
        List<QuestionBlank> questions = getquestionMapper.getQuestionBlank(request.getPaperId());
        return Result.success(questions);
    }
    @PostMapping("/select")
    public Result<List<QuestionSelect>> getQuestionSelect(@RequestBody PaperRequestDTO request) {
        List<QuestionSelect> questions = getquestionMapper.getQuestionSelect(request.getPaperId());
        return Result.success(questions);
    }
    @PostMapping("/shortanswer")
    public Result<List<QuestionShortAnswer>> getQuestionShortAnswer(@RequestBody PaperRequestDTO request) {
        List<QuestionShortAnswer> questions = getquestionMapper.getQuestionShortAnswer(request.getPaperId());
        return Result.success(questions);
    }
    @PostMapping("/tf")
    public Result<List<QuestionTF>> getQuestionTF(@RequestBody PaperRequestDTO request) {
        List<QuestionTF> questions = getquestionMapper.getQuestionTF(request.getPaperId());
        return Result.success(questions);
    }

}
