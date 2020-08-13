package com.dw.summer.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dw.summer.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dw.summer.vo.TeacherVO;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dw
 * @since 2020-07-27
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

    @Select("select teacher.*,department.dept_name from teacher inner join department on \n" +
            "teacher.dept_id = department.dept_id")
    List<TeacherVO> findAllPages(Page<TeacherVO> page);
}
