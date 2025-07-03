package cn.com.chinahitech.bjmarket.exam.Mapper;

import cn.com.chinahitech.bjmarket.exam.Entity.QuestionBank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionBankMapper {

    // 查询所有题库
    @Select("SELECT * FROM question_bank")
    List<QuestionBank> findAll();

    // 根据分类查询
    @Select("SELECT * FROM question_bank WHERE category = #{category}")
    List<QuestionBank> findByCategory(String category);

    // 按创建时间排序（最新在前）
    @Select("SELECT * FROM question_bank ORDER BY created_at DESC")
    List<QuestionBank> findAllOrderByCreatedTime();

    // 使用全文搜索查找题库名称或描述中包含关键词的记录（需使用 MATCH...AGAINST）
    @Select("SELECT * FROM question_bank WHERE q_bank_name LIKE CONCAT('%', #{keyword}, '%') OR description LIKE CONCAT('%', #{keyword}, '%')")



    List<QuestionBank> searchByKeyword(String keyword);
}
