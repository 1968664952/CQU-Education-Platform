package cn.com.chinahitech.bjmarket.information.competition_message.controller;


import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.information.competition_message.entity.CompetitionMessage;
import cn.com.chinahitech.bjmarket.information.competition_message.service.CompetitionMessageService;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.entity.SearchTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 竞赛信息表 前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2025-07-01
 */
@RestController
@CrossOrigin
@RequestMapping("/information/competition_message")
public class CompetitionMessageController {
    @Autowired
    private CompetitionMessageService competitionMessageService;

    @GetMapping("/list")
    public Result<PageBean<CompetitionMessage>> list(@RequestBody SearchTag searchTag) {
        PageBean<CompetitionMessage> pb =competitionMessageService.getlist(searchTag);
        if(pb==null){
            return Result.error(null);
        }
        return Result.success(pb);
    }

    @GetMapping("/detail")
    public Result<CompetitionMessage> list(@RequestBody MID id){
        CompetitionMessage cm = competitionMessageService.findById(id);
        return Result.success(cm);
    }

}
