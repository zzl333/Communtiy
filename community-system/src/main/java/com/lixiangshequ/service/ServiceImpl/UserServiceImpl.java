package com.lixiangshequ.service.ServiceImpl;

import com.lixiangshequ.entity.User;
import com.lixiangshequ.repository.UserMapper;
import com.lixiangshequ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Override
    public User login(User user) {
        return null;
    }

//    @Autowired
//    UserMapper userMapper;

//    @Override
//    public User login(User user) {
////        User user1 = (User);
////        return userMapper.selectByPrimaryKey(user.getId()) != null
//    }
}
