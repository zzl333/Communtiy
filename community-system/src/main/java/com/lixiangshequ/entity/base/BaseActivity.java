package com.lixiangshequ.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    //入参格式化器，拦截器中传入参数格式化为这种形式保存
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //出参格式化器，返回到前端的数据格式化为这种类型
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;

    @TableField("type")
    private Integer type;

    @TableField("beginTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @TableField("endTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @TableField("hot")
    private Integer hot;
}