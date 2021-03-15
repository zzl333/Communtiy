package com.lixiangshequ.service.ServiceImpl;

import com.lixiangshequ.entity.base.BaseUser;
import com.lixiangshequ.repository.UserMapper;
import com.lixiangshequ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public BaseUser login(BaseUser user) {
        BaseUser res = userMapper.selectByCode(user.getCode());
        if(user == null || !user.getPassword().equals(user.getPassword())) {
            return null;
        }
        return res;
    }
}
