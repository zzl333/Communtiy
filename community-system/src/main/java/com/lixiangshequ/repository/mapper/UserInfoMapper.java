package com.lixiangshequ.repository.mapper;

import com.lixiangshequ.entity.base.BaseUserInfo;
import com.lixiangshequ.repository.base.BaseUserInfoMapper;

public interface UserInfoMapper extends BaseUserInfoMapper {

    BaseUserInfo selectByUid(Integer uid);
}