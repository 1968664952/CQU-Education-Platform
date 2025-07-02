package cn.com.chinahitech.bjmarket.exam.Service;

import cn.com.chinahitech.bjmarket.exam.Entity.TestPaper;
import cn.com.chinahitech.bjmarket.exam.Mapper.TestPaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestPaperService {
    @Autowired
    private TestPaperMapper testPaperMapper;

    public List<TestPaper> getByQBankId(Integer qBankId) {
        return testPaperMapper.getByQBankId(qBankId);
    }
}
