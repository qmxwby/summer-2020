package com.dw.summer.controller;


import com.dw.summer.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

}

