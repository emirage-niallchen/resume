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
@TableName("detail")
@ApiModel(value="DetailPO对象", description="")
public class DetailPO{

    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private Integer id;

    @TableField("image_url")
    private String imageUrl;

    @TableField("title")
    private String title;

    @ApiModelProperty(value = "参与角色",name = "category", example = "String")
    @TableField("category")
    private String category;

    @ApiModelProperty(value = "开发时间",name = "date", example = "String")
    @TableField("date")
    private String date;

    @ApiModelProperty(value = "备注",name = "summary", example = "String")
    @TableField("summary")
    private String summary;

    @ApiModelProperty(value = "大标题",name = "name", example = "String")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "技术选型",name = "technologySelection", example = "String")
    @TableField("technology_selection")
    private String technologySelection;

//    @ApiModelProperty(value = "项目地址",name = "link", example = "String")
//    @TableField("link")
//    private String link;

    @TableField("projectDescription")
    private String projectDescription;

    @TableField("keyPoint")
    private String keyPoint;

    @TableField("state")
    private Integer state;

    @TableField("sort")
    private Integer sort;

}
