package cn.com.chinahitech.bjmarket.exam.Service;

import cn.com.chinahitech.bjmarket.exam.DTO.WrongCollectionDTO;
import cn.com.chinahitech.bjmarket.exam.DTO.WrongQuestionRef;
import cn.com.chinahitech.bjmarket.exam.Entity.*;
import cn.com.chinahitech.bjmarket.exam.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WrongCollectionService {

    @Autowired
    private WrongCollectionMapper mapper;

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


    public Map<String, List<Map<String, Object>>> getWrongQuestionsByStudentId(Integer studentId) {
        List<WrongQuestionRef> refs = wrongCollectionMapper.getWrongQuestionRefsByStudentId(studentId);

        Map<String, List<Map<String, Object>>> result = new HashMap<>();
        result.put("select", new ArrayList<>());
        result.put("tf", new ArrayList<>());
        result.put("blank", new ArrayList<>());
        result.put("shortAnswer", new ArrayList<>());

        for (WrongQuestionRef ref : refs) {
            Integer paperId = ref.getPaperId();
            Integer questionId = ref.getQuestionId();
            String category = ref.getCategory(); // e.g., "shortanswer"
            Timestamp createTime = ref.getCreateTime();

            Map<String, Object> questionMap = null;

            switch (category) {
                case "select":
                    QuestionSelect select = questionSelectMapper.getQuestion(paperId, questionId);
                    if (select != null) questionMap = convertToMap(select);
                    break;
                case "tf":
                    QuestionTF tf = questionTFMapper.getQuestion(paperId, questionId);
                    if (tf != null) questionMap = convertToMap(tf);
                    break;
                case "blank":
                    QuestionBlank blank = questionBlankMapper.getQuestion(paperId, questionId);
                    if (blank != null) questionMap = convertToMap(blank);
                    break;
                case "shortanswer":
                    QuestionShortAnswer sa = questionShortAnswerMapper.getQuestion(paperId, questionId);
                    if (sa != null) questionMap = convertToMap(sa);
                    break;
                default:
                    continue; // 不合法的类型跳过
            }

            if (questionMap != null) {
                questionMap.put("createdAt", createTime);

                // ✅ 正确获取 Map 中的 key，避免大小写 mismatch
                String key = mapCategoryKey(category);
                result.get(key).add(questionMap);
            }
        }

        return result;
    }

    /**
     * 将题目对象转为 Map<String, Object>
     */
    private Map<String, Object> convertToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("字段访问失败: " + obj.getClass().getName(), e);
        }
        return map;
    }

    /**
     * 将数据库中的分类名称转换为 result map 中的 key
     */
    private String mapCategoryKey(String category) {
        switch (category) {
            case "shortanswer":
                return "shortAnswer";
            case "select":
            case "tf":
            case "blank":
                return category;
            default:
                return "unknown"; // 不推荐加入 result map
        }
    }
    public String addWrong(WrongCollectionDTO dto) {
        int count = mapper.countSameWrong(dto.getCategory(), dto.getQuestionId(), dto.getPaperId());
        if (count > 0) {
            return "该类型的题目已经存在错题记录";
        }

        WrongCollection wrong = new WrongCollection();
        wrong.setCategory(dto.getCategory());
        wrong.setStudentId(dto.getStudentId());
        wrong.setQuestionId(dto.getQuestionId());
        wrong.setPaperId(dto.getPaperId());
        wrong.setCreateTime(dto.getCreateTime() != null ? dto.getCreateTime() : new Timestamp(System.currentTimeMillis()));
        int rows = mapper.insertWrong(wrong);
        return rows > 0 ? "插入成功" : "插入失败";
    }
}
