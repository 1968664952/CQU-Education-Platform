package cn.com.chinahitech.bjmarket.exam.Service;

import cn.com.chinahitech.bjmarket.exam.DTO.WrongCollectionDTO;
import cn.com.chinahitech.bjmarket.exam.Entity.WrongCollection;
import cn.com.chinahitech.bjmarket.exam.Mapper.WrongCollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class WrongCollectionService {

    @Autowired
    private WrongCollectionMapper mapper;

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
