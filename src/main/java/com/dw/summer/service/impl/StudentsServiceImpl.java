package com.dw.summer.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dw.summer.entity.Students;
import com.dw.summer.mapper.StudentsMapper;
import com.dw.summer.service.StudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dw.summer.vo.StudentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dw
 * @since 2020-07-27
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements StudentsService {
    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public Page<StudentsVO> findAllStudents(Page<StudentsVO> page){
        return page.setRecords(studentsMapper.findAllPages(page));
    }

}
