package cn.com.chinahitech.bjmarket.exam.Service;

import cn.com.chinahitech.bjmarket.exam.Entity.QuestionBank;
import cn.com.chinahitech.bjmarket.exam.Mapper.QuestionBankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionBankService {

    @Autowired
    private QuestionBankMapper questionBankMapper;

    public List<QuestionBank> getAll() {
        return questionBankMapper.findAll();
    }

    public List<QuestionBank> getByCategory(String category) {
        return questionBankMapper.findByCategory(category);
    }

    public List<QuestionBank> getSortedByCreatedAt() {
        return questionBankMapper.findAllOrderByCreatedTime();
    }

    public List<QuestionBank> search(String keyword) {
        return questionBankMapper.searchByKeyword(keyword);
    }
}
