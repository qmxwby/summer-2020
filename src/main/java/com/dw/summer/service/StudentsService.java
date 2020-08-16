package com.dw.summer.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dw.summer.entity.Students;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dw.summer.vo.StudentsVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dw
 * @since 2020-07-27
 */
public interface StudentsService extends IService<Students> {

    Page<StudentsVO> findAllStudents(Page<StudentsVO> page);
}
