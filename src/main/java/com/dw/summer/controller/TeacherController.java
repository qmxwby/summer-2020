package com.dw.summer.controller;


import com.dw.summer.entity.Result;
import com.dw.summer.entity.Teacher;
import com.dw.summer.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/summer/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @ApiOperation("通过id查询到一个教师")
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable("id") int t_id){
        Result res = new Result();
        Teacher teacher = teacherService.getById(t_id);
        if(teacher!=null){
            res.setFlag(true);
            res.setData(teacher);
            res.setCode(200);
            res.setMsg("查询成功");
        }else {
            res.setFlag(false);
            res.setMsg("查询失败,无此用户");
        }
        return res;
    }

    @ApiOperation("通过id和密码进行教师登陆")
    @GetMapping("/login/{id}/{password}")
    public Result login(@PathVariable("id")int t_id, @PathVariable("password")String password){
        Result res = new Result();
        Teacher teacher = teacherService.getById(t_id);
        if(teacher == null){
            res.setMsg("该用户不存在");
            res.setCode(200);
            res.setFlag(false);
        } else if (!teacher.getTPassword().equals(password)){
            res.setMsg("用户名或密码不正确");
            res.setCode(200);
            res.setFlag(false);
        } else {
            res.setMsg("登陆成功");
            res.setCode(200);
            res.setFlag(true);
            res.setData(teacher);
        }
        return res;
    }

    @ApiOperation("添加教师")
    @PostMapping("/addTeacher")
    public Result addTeacher(@RequestBody Teacher teacher){
        Result res = new Result();
        boolean save = teacherService.save(teacher);
        if(save){
            res.setFlag(save);
            res.setData(teacher);
            res.setCode(200);
            res.setMsg("插入成功！");
        } else {
            res.setFlag(save);
            res.setData(null);
            res.setCode(500);
            res.setMsg("插入失败，可能有重复的学号！");
        }
        return res;
    }

    @ApiOperation("根据id删除教师")
    @DeleteMapping("/delTeacher/{id}")
    public Result delete(@PathVariable("id")int tid){
        Result res = new Result();
        Teacher teacher = teacherService.getById(tid);
        if(teacher!=null){
            teacherService.removeById(tid);
            res.setFlag(true);
            res.setMsg("删除成功！");
            res.setData(teacher);
        }else{
            res.setFlag(false);
            res.setMsg("删除失败,用户不存在");
            res.setData(null);
        }
        return res;
    }
}

