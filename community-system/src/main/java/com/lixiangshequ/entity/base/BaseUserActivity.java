package com.lixiangshequ.entity.base;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user_activity")
public class BaseUserActivity {
    private Integer id;

    private Integer uid;

    private Integer oid;

    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}