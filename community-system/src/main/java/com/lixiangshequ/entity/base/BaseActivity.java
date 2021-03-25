package com.lixiangshequ.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("activity")
@Data
public class BaseActivity {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("title")
    private String title;

    @TableField("info")
    private String info;

    @TableField("address")
    private String address;

    @TableField("images")
    private String images;

    @TableField("createBy")
    private String createBy;

    @TableField("organizer")
    private String organizer;

    @TableField("created")
    private Date created;

    @TableField("type")
    private Integer type;

    @TableField("beginTime")
    private Date beginTime;

    @TableField("endTime")
    private Date endTime;

    @TableField("hot")
    private Integer hot;
}