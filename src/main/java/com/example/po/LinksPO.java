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
@TableName("links")
@ApiModel(value="LinksPO对象", description="")
public class LinksPO{

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("detail_id")
    private Integer detailId;

    @TableField("link")
    private String link;

    @TableField("name")
    private String name;

    @TableField("type")
    private String type;


}
