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
 * 
 * </p>
 *
 * @author generator
 * @since 2024-04-27
 */
@Getter
@Setter
@TableName("dict")
@ApiModel(value="DictPO对象", description="")
public class DictPO{

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父ID，用于表示层级关系",name = "pid", example = "Integer")
    @TableField("pid")
    private Integer pid;

    @ApiModelProperty(value = "字典项名称",name = "name", example = "String")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "字典项代码",name = "code", example = "String")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "字典项值",name = "value", example = "String")
    @TableField("value")
    private String value;


}
