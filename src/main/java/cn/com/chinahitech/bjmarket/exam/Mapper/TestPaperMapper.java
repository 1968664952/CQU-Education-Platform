package cn.com.chinahitech.bjmarket.exam.Mapper;

import cn.com.chinahitech.bjmarket.exam.Entity.TestPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestPaperMapper {

    @Select("SELECT * FROM test_paper WHERE q_bank_id = #{qBankId}")
    List<TestPaper> getByQBankId(Integer qBankId);
}
