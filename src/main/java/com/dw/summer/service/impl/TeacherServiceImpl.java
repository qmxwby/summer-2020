package com.dw.summer.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dw.summer.entity.Teacher;
import com.dw.summer.mapper.TeacherMapper;
import com.dw.summer.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dw.summer.vo.TeacherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dw
 * @since 2020-07-27
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public Page<TeacherVO> findAllTeacher(Page<TeacherVO> page) {
        return page.setRecords(teacherMapper.findAllPages(page));
    }
}
