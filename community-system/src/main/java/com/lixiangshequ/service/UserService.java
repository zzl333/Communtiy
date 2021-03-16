package com.lixiangshequ.service;

import com.lixiangshequ.config.ResposeMessage;
import com.lixiangshequ.entity.base.BaseUser;
import com.lixiangshequ.entity.base.BaseUserInfo;

public interface UserService {
    ResposeMessage<BaseUserInfo> login(BaseUser user);
}
