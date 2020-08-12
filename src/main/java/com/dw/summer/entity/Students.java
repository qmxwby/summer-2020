package com.dw.summer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dw
 * @since 2020-07-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Students对象", description="")
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学生编号")
    @TableId(value = "stu_id", type = IdType.ID_WORKER)
    private Integer stuId;

    @ApiModelProperty(value = "学生姓名")
    private String stuName;

    @ApiModelProperty(value = "学生性别")
    private String stuSex;

    @ApiModelProperty(value = "入学年份")
    private Integer stuInyear;

    @ApiModelProperty(value = "所属系别")
    private Integer deptId;

    @ApiModelProperty(value = "所学专业")
    private Integer majorId;

    @ApiModelProperty(value = "班级")
    private Integer stuClass;

    @ApiModelProperty(value = "登录密码")
    private String stuPassword;


}
