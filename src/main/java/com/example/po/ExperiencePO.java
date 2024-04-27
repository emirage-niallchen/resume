package com.example.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 职业生涯表
 * </p>
 *
 * @author generator
 * @since 2024-04-27
 */
@Getter
@Setter
@TableName("experience")
@ApiModel(value="ExperiencePO对象", description="职业生涯表")
public class ExperiencePO{

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "工作时间",name = "period", example = "String")
    @TableField("period")
    private String period;

    @ApiModelProperty(value = "公司、组织名称",name = "organization", example = "String")
    @TableField("organization")
    private String organization;

    @ApiModelProperty(value = "从事职业",name = "role", example = "String")
    @TableField("role")
    private String role;

    @ApiModelProperty(value = "备注、描述",name = "remark", example = "String")
    @TableField("remark")
    private String remark;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "备注、描述",name = "remark", example = "String")
    @TableField("state")
    private String state;


}
