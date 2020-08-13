package com.dw.summer.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dw.summer.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dw.summer.vo.TeacherVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dw
 * @since 2020-07-27
 */
public interface TeacherService extends IService<Teacher> {

    Page<TeacherVO> findAllTeacher(Page<TeacherVO> page);
}
