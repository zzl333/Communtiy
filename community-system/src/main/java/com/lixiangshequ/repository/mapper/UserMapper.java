package com.lixiangshequ.repository.mapper;

import com.lixiangshequ.entity.base.BaseUser;
import com.lixiangshequ.repository.base.BaseUserMapper;

public interface UserMapper extends BaseUserMapper {

    /**
     * 通过code查询用户
     */
    BaseUser selectByCode(String code);
}
