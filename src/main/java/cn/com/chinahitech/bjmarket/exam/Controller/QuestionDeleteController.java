package cn.com.chinahitech.bjmarket.exam.Controller;

import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.exam.DTO.DeleteQuestionDTO;
import cn.com.chinahitech.bjmarket.exam.Mapper.QuestionBlankMapper;
import cn.com.chinahitech.bjmarket.exam.Mapper.QuestionSelectMapper;
import cn.com.chinahitech.bjmarket.exam.Mapper.QuestionShortAnswerMapper;
import cn.com.chinahitech.bjmarket.exam.Mapper.QuestionTFMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class QuestionDeleteController {

    @Autowired
    private QuestionTFMapper tfMapper;
    @Autowired private QuestionSelectMapper selectMapper;
    @Autowired private QuestionBlankMapper blankMapper;
    @Autowired private QuestionShortAnswerMapper shortAnswerMapper;

    @PostMapping("/exam/paper/question/delete")
    public Result<String> deleteQuestion(@RequestBody DeleteQuestionDTO dto) {
        String type = dto.getType();
        Integer id = dto.getQuestionId();

        if (id == null || type == null) {
            return Result.error("缺少 questionId 或 type 参数");
        }

        boolean success = false;

        switch (type) {
            case "tf":
                success = tfMapper.deleteById(id) > 0;
                break;
            case "select":
                success = selectMapper.deleteById(id) > 0;
                break;
            case "blank":
                success = blankMapper.deleteById(id) > 0;
                break;
            case "shortAnswer":
                success = shortAnswerMapper.deleteById(id) > 0;
                break;
            default:
                return Result.error("未知的题型类型: " + type);
        }

        return success ? Result.success("删除成功") : Result.error("删除失败，题目可能不存在");
    }
}
