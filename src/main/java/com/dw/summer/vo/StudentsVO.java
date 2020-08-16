package com.dw.summer.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class StudentsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("学号")
    @TableId(value = "s_id", type = IdType.ID_WORKER)
    private Integer stuId;

    @ApiModelProperty("姓名")
    private String stuName;

    @ApiModelProperty("性别")
    private String stuSex;

    @ApiModelProperty("入学年份")
    private Integer stuInyear;

    @ApiModelProperty("系号")
    private Integer deptId;
    private String deptName;

    @ApiModelProperty("专业号")
    private Integer majorId;
    private String majorName;

    @ApiModelProperty("班级")
    private Integer stuClass;

    @ApiModelProperty("登录密码")
    private String stuPassword;

}
