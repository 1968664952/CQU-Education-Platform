package cn.com.chinahitech.bjmarket.exam.Controller;
import cn.com.chinahitech.bjmarket.common.Result;

import cn.com.chinahitech.bjmarket.exam.DTO.AllQuestionsResponseDTO;
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

    @PostMapping("/question")
    public Result<AllQuestionsResponseDTO> getAllQuestions(@RequestBody PaperRequestDTO request) {
        try {
            AllQuestionsResponseDTO dto = new AllQuestionsResponseDTO();
            dto.setBlank(getquestionMapper.getQuestionBlank(request.getPaperId()));
            dto.setSelect(getquestionMapper.getQuestionSelect(request.getPaperId()));
            dto.setShortanswer(getquestionMapper.getQuestionShortAnswer(request.getPaperId()));
            dto.setTf(getquestionMapper.getQuestionTF(request.getPaperId()));

            // 如果全部为空，也返回提示
            if ((dto.getBlank() == null || dto.getBlank().isEmpty()) &&
                    (dto.getSelect() == null || dto.getSelect().isEmpty()) &&
                    (dto.getShortanswer() == null || dto.getShortanswer().isEmpty()) &&
                    (dto.getTf() == null || dto.getTf().isEmpty())) {
                return Result.error("所有题型均为空");
            }

            return Result.success(dto);
        } catch (Exception e) {
            return Result.error("查询所有题型失败：" + e.getMessage());
        }
    }



}
