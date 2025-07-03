package cn.com.chinahitech.bjmarket.information.gee_message.controller;


import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.information.gee_message.entity.GeeMessage;
import cn.com.chinahitech.bjmarket.information.gee_message.service.GeeMessageService;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.entity.SearchTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 考研信息公示表 前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
@RestController
@CrossOrigin
@RequestMapping("/information/gee_message")
public class GeeMessageController {
    @Autowired
    private GeeMessageService geeMessageService;

    @PostMapping("/list")
    public Result<PageBean<GeeMessage>> list(@RequestBody SearchTag searchTag) {
        PageBean<GeeMessage> pb = geeMessageService.getlist(searchTag);
        return Result.success(pb);
    }

    @PostMapping("/detail")
    public Result<GeeMessage> list(@RequestBody MID id){
        GeeMessage cm = geeMessageService.findById(id);
        if(cm!=null) {
            return Result.success(cm);
        }
        else  {
            return Result.error(null);
        }
    }

}
