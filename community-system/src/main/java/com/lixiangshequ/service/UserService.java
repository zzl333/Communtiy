package com.lixiangshequ.service;

import com.lixiangshequ.config.ResponseMessage;
import com.lixiangshequ.entity.base.BaseUser;
import com.lixiangshequ.entity.base.BaseUserInfo;
import com.lixiangshequ.repository.mapper.UserInfoMapper;
import com.lixiangshequ.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    public ResponseMessage<BaseUserInfo> login(BaseUser user) {
        logger.info("login");
        ResponseMessage<BaseUserInfo> res = new ResponseMessage<>();
        BaseUser baseUser = userMapper.selectByCode(user.getCode());

        if (baseUser == null) {
            res.setMsg("该用户不存在！");
            res.setUrl("/login");
            return res;
        }
        if (!user.getPassword().equals(baseUser.getPassword())) {
            res.setMsg("密码不正确！");
            res.setUrl("/login");
            return res;
        }
        if(user.getRole() != baseUser.getRole()) {
            res.setMsg("角色错误！");
            res.setUrl("/login");
            return res;
        }

        res.setData(userInfoMapper.selectByUid(baseUser.getId()));
        res.setMsg("登录成功");
        if (baseUser.getRole() == 2) {
            res.setUrl("/admin/index");
        }else {
            res.setUrl("/index");
        }

        return res;
    }
}
