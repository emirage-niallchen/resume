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
@TableName("index_home")
@ApiModel(value="IndexPO对象", description="")
public class IndexPO{

    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private Integer id;

    @TableField("index_title")
    private String indexTitle;

    @ApiModelProperty(value = "菜单栏图标",name = "faviconIcon", example = "String")
    @TableField("favicon_icon")
    private String faviconIcon;

    @ApiModelProperty(value = "显示的头像",name = "logoPath", example = "String")
    @TableField("logo_path")
    private String logoPath;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("weixin")
    private String weixin;

    @ApiModelProperty(value = "hi 我是陈博云",name = "animation", example = "String")
    @TableField("animation")
    private String animation;

    @ApiModelProperty(value = "个性符号1",name = "typed1", example = "String")
    @TableField("typed_1")
    private String typed1;

    @ApiModelProperty(value = "个性符号2",name = "typed2", example = "String")
    @TableField("typed_2")
    private String typed2;

    @TableField("typed_3")
    private String typed3;

    @TableField("typed_4")
    private String typed4;

    @TableField("my_image")
    private String myImage;

    @TableField("about_img")
    private String aboutImg;

    @ApiModelProperty(value = "描述信息",name = "aboutMe", example = "String")
    @TableField("about_me")
    private String aboutMe;

    @TableField("birthday")
    private String birthday;

    @TableField("blog")
    private String blog;

    @TableField("job_expectation")
    private String jobExpectation;

    @ApiModelProperty(value = "作品集  为什么有这个",name = "portfolio", example = "String")
    @TableField("portfolio")
    private String portfolio;

    @ApiModelProperty(value = "职业生涯标题",name = "experienceTitle", example = "String")
    @TableField("experience_title")
    private String experienceTitle;

    @TableField("copy_right")
    private String copyRight;

    @TableField("right_url")
    private String rightUrl;

    @TableField("right_name")
    private String rightName;


}
