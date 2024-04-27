package com.example.po;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Common {

    private String logoPath;

    private String faviconIcon;

    private String phone;

    private String email;

    private String weixin;

    private String copyRight;

    private String rightUrl;

    private String rightName;

}
