package cn.com.chinahitech.bjmarket.exam.Service;

import cn.com.chinahitech.bjmarket.exam.DTO.DeleteWrongCollectionRequest;
import cn.com.chinahitech.bjmarket.exam.Mapper.WrongCollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// src/main/java/com/example/service/impl/WrongCollectionServiceImpl.java
@Service
public class WrongCollectionServiceImpl  {

    @Autowired
    private WrongCollectionMapper wrongCollectionMapper;


    public boolean removeWrongQuestion(DeleteWrongCollectionRequest request) {
        int rows = wrongCollectionMapper.deleteWrongCollection(
                request.getCategory(),
                request.getStudentId(),
                request.getQuestionId(),
                request.getPaperId()
        );
        return rows > 0;
    }
}
