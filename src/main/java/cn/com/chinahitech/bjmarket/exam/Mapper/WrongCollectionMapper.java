package cn.com.chinahitech.bjmarket.exam.Mapper;

import cn.com.chinahitech.bjmarket.exam.DTO.TestPaperWithBank;
import cn.com.chinahitech.bjmarket.exam.DTO.WrongQuestionRef;
import cn.com.chinahitech.bjmarket.exam.Entity.QuestionBank;
import cn.com.chinahitech.bjmarket.exam.Entity.TestPaper;
import cn.com.chinahitech.bjmarket.exam.Entity.WrongCollection;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WrongCollectionMapper {

    @Select("SELECT paper_id, question_id, category,create_time FROM wrong_collection WHERE student_id = #{studentId}")
    List<WrongQuestionRef> getWrongQuestionRefsByStudentId(@Param("studentId") Integer studentId);
    @Select("SELECT COUNT(*) FROM wrong_collection WHERE category = #{category} AND question_id = #{questionId} AND paper_id = #{paperId} AND student_id = #{studentId}")
    int countSameWrong(@Param("category") String category,
                       @Param("questionId") int questionId,
                       @Param("paperId") int paperId,
                       @Param("studentId") String studentId);


    @Insert("INSERT INTO wrong_collection(category, student_id, question_id, paper_id,create_time) " +
            "VALUES(#{category}, #{studentId}, #{questionId}, #{paperId}, #{createTime})")
    int insertWrong(WrongCollection wrong);

    @Delete("DELETE FROM wrong_collection " +
                "WHERE category = #{category} " +
                "AND student_id = #{studentId} " +
                "AND question_id = #{questionId} " +
                "AND paper_id = #{paperId}")
    int deleteWrongCollection(@Param("category") String category,
                                  @Param("studentId") String studentId,
                                  @Param("questionId") int questionId,
                                  @Param("paperId") int paperId);
    @Select("SELECT p.paper_id, p.title AS paperTitle, p.description AS paperDescription, " +
            "q.q_bank_id, q.q_bank_name, q.description AS qBankDescription, q.category AS qBankCategory " +
            "FROM test_paper p JOIN question_bank q ON p.q_bank_id = q.q_bank_id " +
            "WHERE p.paper_id = #{paperId}")
    @Results({
            @Result(column = "paper_id", property = "paperId"),
            @Result(column = "paperTitle", property = "title"),
            @Result(column = "paperDescription", property = "description"),
            @Result(column = "q_bank_id", property = "qBankId"),
            @Result(column = "q_bank_name", property = "qBankName"),
            @Result(column = "qBankDescription", property = "qBankDescription"),
            @Result(column = "qBankCategory", property = "qBankCategory")
    })
    TestPaperWithBank selectPaperWithBankInfo(@Param("paperId") Integer paperId);

}
