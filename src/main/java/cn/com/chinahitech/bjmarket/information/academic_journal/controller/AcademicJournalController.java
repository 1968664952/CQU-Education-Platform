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
@RequestMapping("/information/academic_journal")
public class AcademicJournalController {
    @Autowired
    private AcademicJournalService academicJournalService;

    @PostMapping("/post")
    public Result<?> add(@RequestBody AcademicJournal new1) {
            academicJournalService.add(new1);
            return Result.success(null);
    }

    @GetMapping("/list")
    public Result<PageBean<AcademicJournal>> list(@RequestBody SearchTag searchTag){
        PageBean<AcademicJournal> pb = academicJournalService.getlist(searchTag);
        return Result.success(pb);
    }

    @GetMapping("/detail")
    public Result<AcademicJournal> list(@RequestBody MID id){
        AcademicJournal aj = academicJournalService.findById(id);
        return Result.success(aj);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody @Validated AcademicJournal journal){
        academicJournalService.toupdate(journal);
        return Result.success(null);
    }

    @DeleteMapping("delete")
    public  Result<?> delete(@RequestBody MID id){
        academicJournalService.delete(id);
        return Result.success(null);
    }

}
