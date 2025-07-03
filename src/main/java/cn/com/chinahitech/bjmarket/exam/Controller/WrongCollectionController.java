package cn.com.chinahitech.bjmarket.exam.Controller;

import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.exam.DTO.WrongCollectionDTO;
import cn.com.chinahitech.bjmarket.exam.Service.WrongCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wrongCollection")
public class WrongCollectionController {

    @Autowired
    private WrongCollectionService wrongCollectionService;

    @PostMapping("/add")
    public Result<String> addWrongCollection(@RequestBody WrongCollectionDTO dto) {
        try {
            String message = wrongCollectionService.addWrong(dto);
            if ("插入成功".equals(message)) {
                return Result.success(message);
            } else {
                return Result.error(message);
            }
        } catch (Exception e) {
            return Result.error("插入失败：" + e.getMessage());
        }
    }
}
