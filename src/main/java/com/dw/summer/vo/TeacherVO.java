package com.dw.summer.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class TeacherVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教师编号")
    @TableId(value = "t_id", type = IdType.ID_WORKER)
    private Integer tId;

    @ApiModelProperty(value = "教师姓名")
    private String tName;

    @ApiModelProperty(value = "教师性别")
    private String tSex;

    @ApiModelProperty(value = "入职年份")
    private Integer tInyear;

    @ApiModelProperty(value = "系别")
    private Integer deptId;

    private String deptName;

    @ApiModelProperty(value = "职称")
    private String tProf;

    @ApiModelProperty(value = "登录密码")
    private String tPassword;

}
