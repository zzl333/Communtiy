package com.lixiangshequ.entity;

import lombok.Data;

/**
 * 管理员用户管理专用，结合用户表与
 *
 * @author 张祥麟
 * @Date 2021/3/26
 * @Version 1.0
 */
@Data
public class UserVo {

    private String code;        //用户账号编码--不可改

    private Integer role;       //用户角色 1普通用户  2管理员   参考config表

    private Integer id;     //用户id  不可改

    private String name;    //用户姓名

    private String sex;     //用户性别

    private Integer age;    //用户年龄

    private String mCode;      //党员唯一标识

    private String mobile;      //电话号码

    private String address;     //住址

    private String head;        //头像
}
