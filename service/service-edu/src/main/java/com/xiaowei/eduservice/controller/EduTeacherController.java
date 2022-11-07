package com.xiaowei.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaowei.eduservice.entity.EduTeacher;
import com.xiaowei.eduservice.service.EduTeacherService;
import com.xiaowei.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author xiaowei
 * @since 2022-11-05
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("findAll")
    public R<List<EduTeacher>> findAll()
    {
        return R.ok().data(eduTeacherService.list(null));
    }

    @DeleteMapping("/{id}")
    public R remove(@PathVariable("id") String id)
    {
        return eduTeacherService.removeById(id) ? R.ok() : R.fail();
    }

    @ApiOperation("分页查询讲师")
    @GetMapping("page/teacher/{pageNo}/{pageSize}")
    public R pageTeacher(@PathVariable("pageNo") Long pageNo, @PathVariable("pageSize") Long pageSize)
    {
        Page<EduTeacher> page = new Page<>(pageNo, pageSize);
        eduTeacherService.page(page, null);
        return R.ok().data(page);
    }

    @ApiOperation("新增讲师")
    @PostMapping
    public R add(@RequestBody EduTeacher teacher)
    {
        return eduTeacherService.save(teacher) ? R.ok() : R.fail();
    }
}

