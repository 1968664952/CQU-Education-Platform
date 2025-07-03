package cn.com.chinahitech.bjmarket.exam.Controller;

import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.exam.DTO.QuestionUploadDTO;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionBlank;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionSelect;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionShortAnswer;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionTF;
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
public class QuestionUploadController {

    @Autowired
    private QuestionTFMapper tfMapper;
    @Autowired private QuestionSelectMapper selectMapper;
    @Autowired private QuestionBlankMapper blankMapper;
    @Autowired private QuestionShortAnswerMapper shortAnswerMapper;

    @PostMapping("/exam/paper/question/upload")
    public Result<String> uploadQuestions(@RequestBody QuestionUploadDTO data) {
        try {
            if (data.getTf() != null) {
                for (QuestionTF tf : data.getTf()) {
                    tfMapper.insert(tf);
                }
            }
            if (data.getSelect() != null) {
                for (QuestionSelect sel : data.getSelect()) {
                    selectMapper.insert(sel);
                }
            }
            if (data.getBlank() != null) {
                for (QuestionBlank blank : data.getBlank()) {
                    blankMapper.insert(blank);
                }
            }
            if (data.getShortAnswer() != null) {
                for (QuestionShortAnswer sa : data.getShortAnswer()) {
                    shortAnswerMapper.insert(sa);
                }
            }
            return Result.success("题目上传成功");
        } catch (Exception e) {
            return Result.error("上传失败: " + e.getMessage());
        }
    }
}
