package cn.com.chinahitech.bjmarket.exam.Service;

import cn.com.chinahitech.bjmarket.exam.DTO.WrongQuestionRef;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionBlank;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionSelect;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionShortAnswer;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionTF;
import cn.com.chinahitech.bjmarket.exam.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WrongCollectionService {

    @Autowired
    private WrongCollectionMapper wrongCollectionMapper;

    @Autowired
    private QuestionSelectMapper questionSelectMapper;

    @Autowired
    private QuestionTFMapper questionTFMapper;

    @Autowired
    private QuestionBlankMapper questionBlankMapper;

    @Autowired
    private QuestionShortAnswerMapper questionShortAnswerMapper;

    public Map<String, List<Object>> getWrongQuestionsByStudentId(Integer studentId) {
        List<WrongQuestionRef> refs = wrongCollectionMapper.getWrongQuestionRefsByStudentId(studentId);

        Map<String, List<Object>> result = new HashMap<>();
        result.put("select", new ArrayList<>());
        result.put("tf", new ArrayList<>());
        result.put("blank", new ArrayList<>());
        result.put("shortAnswer", new ArrayList<>());

        for (WrongQuestionRef ref : refs) {
            Integer paperId = ref.getPaperId();
            Integer questionId = ref.getQuestionId();
            String category = ref.getCategory();

            switch (category) {
                case "选择":
                    QuestionSelect select = questionSelectMapper.getQuestion(paperId, questionId);
                    if (select != null) result.get("select").add(select);
                    break;
                case "判断":
                    QuestionTF tf = questionTFMapper.getQuestion(paperId, questionId);
                    if (tf != null) result.get("tf").add(tf);
                    break;
                case "填空":
                    QuestionBlank blank = questionBlankMapper.getQuestion(paperId, questionId);
                    if (blank != null) result.get("blank").add(blank);
                    break;
                case "简答":
                    QuestionShortAnswer sa = questionShortAnswerMapper.getQuestion(paperId, questionId);
                    if (sa != null) result.get("shortAnswer").add(sa);
                    break;
            }
        }

        return result;
    }
}
