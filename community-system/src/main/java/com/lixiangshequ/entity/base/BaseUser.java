package com.lixiangshequ.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")
@Data
public class BaseUser {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("code")
    private String code;

    @TableField("password")
    private String password;

    @TableField("salt")
    private String salt;

    @TableField("role")
    private Integer role;

}