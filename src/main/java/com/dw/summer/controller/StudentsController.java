package com.dw.summer.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dw.summer.entity.Result;
import com.dw.summer.entity.Students;
import com.dw.summer.service.StudentsService;
import com.dw.summer.vo.StudentsVO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dw
 * @since 2020-07-27
 */
@CrossOrigin(origins = "*", maxAge = 3600)  //解决跨域问题
@RestController
@RequestMapping("/summer/students")
public class StudentsController {

    @Autowired
    StudentsService studentsService;

    @ApiOperation("通过id查询到一个学生")
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable("id") int s_id) {
        Result res = new Result();
        Students students = studentsService.getById(s_id);
        if (students != null) {
            res.setData(students);
            res.setCode(200);
            res.setMsg("查询成功");
        } else {
            res.setCode(500);
            res.setMsg("查询失败，无此用户");
        }
        return res;
    }

    @ApiOperation("通过id和密码进行学生登录")
    @GetMapping("/login/{id}/{password}")
    public Result login(@PathVariable("id") int s_id, @PathVariable("password") String password) {
        Result res = new Result();
        Students students = studentsService.getById(s_id);
        if (students == null) {
            res.setCode(500);
            res.setMsg("该用户不存在");
        } else if (!students.getStuPassword().equals(password)) {
            res.setCode(500);
            res.setMsg("用户名或密码不正确");
        } else {
            res.setMsg("登录成功");
            res.setCode(200);
            res.setData(students);
        }
        return res;
    }

    @ApiOperation("添加学生")
    @PostMapping("/addStudents")
    public Result addStudent(@RequestBody Students students) {
        Result res = new Result();
        boolean save = studentsService.save(students);
        if (save) {
            res.setData(students);
            res.setCode(200);
            res.setMsg("插入成功");
        } else {
            res.setData(null);
            res.setCode(500);
            res.setMsg("插入失败，可能有重复的学号");
        }
        return res;
    }

    @ApiOperation("根据id删除学生")
    @DeleteMapping("/delStudents/{id}")
    public Result delStudents(@PathVariable("id") int s_id) {
        Result res = new Result();
        Students students = studentsService.getById(s_id);
        if (students != null) {
            studentsService.removeById(s_id);
            res.setMsg("删除学生成功");
            res.setCode(200);
            res.setData(students);
        } else {
            res.setData(null);
            res.setCode(500);
            res.setMsg("删除失败,用户不存在");
        }
        return res;
    }

    @ApiOperation("获取所有学生的信息,并实现分页")
    @GetMapping("/getAll/{pageNo}/{pageSize}")
    public Result getAll(@PathVariable("pageNo") int pageNo,
                         @PathVariable("pageSize") int pageSize) {
        Result res = new Result();
        Page<StudentsVO> studentsVOPage = studentsService.findAllStudents(new Page<>(pageNo, pageSize));
        if (studentsVOPage.getRecords().size() == 0) {
            res.setCode(0);
            res.setMsg("请求失败！");
        } else {
            res.setData(studentsVOPage);
            res.setCode(200);
            res.setMsg("请求成功!");
        }
        return res;
    }

    @ApiOperation("根据id对学生进行批量删除")
    @DeleteMapping("/deleteByList")
    public Result deleteByList(@RequestParam(value = "ids[]") List<String> ids) {
        Result res = new Result();
        studentsService.removeByIds(ids);
        res.setCode(200);
        res.setMsg("删除成功！");
        return res;
    }
}

