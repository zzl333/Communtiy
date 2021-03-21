package com.lixiangshequ.entity.base;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("config")
public class BaseConfig {
    private Integer id;

    private String type;

    private String typedes;

    private String code;

    private String codedes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTypedes() {
        return typedes;
    }

    public void setTypedes(String typedes) {
        this.typedes = typedes == null ? null : typedes.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCodedes() {
        return codedes;
    }

    public void setCodedes(String codedes) {
        this.codedes = codedes == null ? null : codedes.trim();
    }
}