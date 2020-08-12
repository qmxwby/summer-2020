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
@ApiModel(value="Teacher对象", description="")
public class Teacher implements Serializable {

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

    @ApiModelProperty(value = "职称")
    private String tProf;

    @ApiModelProperty(value = "登录密码")
    private String tPassword;


}
