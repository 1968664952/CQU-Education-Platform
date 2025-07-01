package cn.com.chinahitech.bjmarket.academic_journal.controller;


import cn.com.chinahitech.bjmarket.academic_journal.entity.AcademicJournal;
import cn.com.chinahitech.bjmarket.academic_journal.service.AcademicJournalService;
import cn.com.chinahitech.bjmarket.academic_journal.service.impl.AcademicJournalServiceImpl;
import cn.com.chinahitech.bjmarket.common.Result;
import cn.com.chinahitech.bjmarket.PageBean;
import cn.com.chinahitech.bjmarket.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * <p>
 * 学术期刊信息表 前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2025-06-30
 */
@RestController
@RequestMapping("/academic_journal")
public class AcademicJournalController {
    @Autowired
    private AcademicJournalService academicJournalService;

    @PostMapping("/post")
    public Result<?> add(@RequestBody AcademicJournal new1) {
            academicJournalService.add(new1);
            return Result.success(null);
    }

    @GetMapping("/list")
    public Result<PageBean<AcademicJournal>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String publisher
    ){
        PageBean<AcademicJournal> pb = academicJournalService.getlist(pageNum,pageSize,title,publisher);
        return Result.success(pb);
    }

    @GetMapping("/detail")
    public Result<AcademicJournal> list(Integer id){
        AcademicJournal aj = academicJournalService.findById(id);
        return Result.success(aj);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody @Validated AcademicJournal journal){
        academicJournalService.toupdate(journal);
        return Result.success(null);
    }

    @DeleteMapping("delete")
    public  Result<?> delete(int id){
        academicJournalService.delete(id);
        return Result.success(null);
    }

}
