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
@TableName("source")
@ApiModel(value="SourcePO对象", description="")
public class SourcePO{

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "资源名称",name = "name", example = "String")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "资源类型",name = "type", example = "String")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "资源父类型",name = "typeP", example = "String")
    @TableField("type_p")
    private String typeP;

    @ApiModelProperty(value = "值字段1",name = "val1", example = "String")
    @TableField("val_1")
    private String val1;

    @ApiModelProperty(value = "值字段2",name = "val2", example = "String")
    @TableField("val_2")
    private String val2;

    @ApiModelProperty(value = "值字段3",name = "val3", example = "String")
    @TableField("val_3")
    private String val3;

    @ApiModelProperty(value = "排序字段",name = "sort", example = "Integer")
    @TableField("sort")
    private Integer sort;

    @TableField("state")
    private Integer state;

}
