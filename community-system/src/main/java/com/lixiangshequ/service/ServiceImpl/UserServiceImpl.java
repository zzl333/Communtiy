package com.lixiangshequ.service.ServiceImpl;

import com.lixiangshequ.entity.User;
import com.lixiangshequ.repository.UserMapper;
import com.lixiangshequ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {
        User userRes = (User) userMapper.selectByPrimaryKey(user.getId());
        if(userRes == null || !user.getPassword().equals(userRes.getPassword())) {
            return null;
        }
        return userRes;
    }
}
