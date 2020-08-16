package com.dw.summer.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dw.summer.entity.Students;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dw.summer.vo.StudentsVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dw
 * @since 2020-07-27
 */
public interface StudentsMapper extends BaseMapper<Students> {

    @Select({"select  students.*,department.dept_name,major.major_name from students left join department on students.dept_id = department.dept_id left join major on students.major_id = major.major_id"})
    List<StudentsVO> findAllPages(Page<StudentsVO> page);

}
