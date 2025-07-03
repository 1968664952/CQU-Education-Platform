package cn.com.chinahitech.bjmarket.information.academic_journal.controller;


import cn.com.chinahitech.bjmarket.information.academic_journal.entity.AcademicJournal;
import cn.com.chinahitech.bjmarket.information.academic_journal.service.AcademicJournalService;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.information.entity.MID;
import cn.com.chinahitech.bjmarket.information.entity.SearchTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 学术期刊信息表 前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2025-06-30
 */
@RestController
@CrossOrigin
@RequestMapping("/information/academic_journal")
public class AcademicJournalController {
    @Autowired
    private AcademicJournalService academicJournalService;

    @GetMapping("/list")
    public Result<PageBean<AcademicJournal>> list(@RequestBody SearchTag searchTag){
        PageBean<AcademicJournal> pb = academicJournalService.getlist(searchTag);
        return Result.success(pb);
    }

    @GetMapping("/detail")
    public Result<AcademicJournal> list(@RequestBody MID id){
        AcademicJournal aj = academicJournalService.findById(id);
        if(aj!=null) {
            return Result.success(aj);
        }
        else  {
            return Result.error(null);
        }
    }

}
