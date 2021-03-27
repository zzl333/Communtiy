package com.lixiangshequ.service;

import com.lixiangshequ.config.PageResponse;
import com.lixiangshequ.config.ResponseMessage;
import com.lixiangshequ.entity.UserVo;
import com.lixiangshequ.entity.base.BaseUser;
import com.lixiangshequ.entity.base.BaseUserInfo;
import com.lixiangshequ.repository.mapper.UserInfoMapper;
import com.lixiangshequ.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService extends BaseService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    public ResponseMessage<BaseUserInfo> login(BaseUser user) {
        logger.info("login");
        ResponseMessage<BaseUserInfo> res = new ResponseMessage<>();
        Map<String, Object> map = new HashMap<>();
        map.put("code", user.getCode());
        List<BaseUser> baseUsers = userMapper.selectByMap(map);

        if (baseUsers == null || baseUsers.size() < 1) {
            res.setSuccess(false);
            res.setMsg("该用户不存在！");
            res.setUrl("/login");
            return res;
        }
        BaseUser baseUser = baseUsers.get(0);
        if (!user.getPassword().equals(baseUser.getPassword())) {
            res.setSuccess(false);
            res.setMsg("密码不正确！");
            res.setUrl("/login");
            return res;
        }
        if(user.getRole() != baseUser.getRole()) {
            res.setMsg("角色错误！");
            res.setUrl("/login");
            return res;
        }


        map.clear();
        map.put("uid", baseUser.getId());
        res.setData(userInfoMapper.selectByMap(map).get(0));
        res.setSuccess(true);
        res.setMsg("登录成功");
        if (baseUser.getRole() == 2) {
            res.setUrl("redirect:/page/admin/index");
        }else {
            res.setUrl("redirect:/page/index");
        }

        return res;
    }

    /**
     * @return
     */
    public boolean isAdmin(HttpSession session) {
        BaseUserInfo user = (BaseUserInfo) session.getAttribute("user");
        if (user == null) return false;
        BaseUser baseUser = userMapper.selectById(user.getUid());
        if (baseUser == null || baseUser.getRole() != 2) return false;
        return true;
    }

    /**
     * 成员校验
     *
     * @param session
     * @return
     */
    public boolean isMember(HttpSession session) {
        BaseUserInfo user = (BaseUserInfo) session.getAttribute("user");
        if (user == null) return false;
        BaseUser baseUser = userMapper.selectById(user.getUid());
        if (baseUser == null || baseUser.getRole() != 1) return false;
        return true;
    }

    /**
     * 是否为登录状态
     *
     * @author 张祥麟
     * @Date 2021/3/19
     * @Version 1.0
     */
    public boolean isLogin(HttpSession session) {
        if (session.getAttribute("user") == null) return false;
        return true;
    }


    /**
     * 获取用户session
     *
     * @Author 张祥麟
     * @Date 2021/3/24
     * @Param
     * @Return
     */
    public BaseUserInfo getUserInfo(HttpSession session) {
        return (BaseUserInfo) session.getAttribute("user");
    }

    /**
     * 管理员查询用户信息方法
     *
     * @Author 张祥麟
     * @Date 2021/3/26
     * @Param
     * @Return
     */
    public PageResponse<UserVo> find(HttpSession session) {
        PageResponse<UserVo> res = new PageResponse<>();
        if (!isAdmin(session)) {
            res.setCode(400);
            res.setMsg("没有管理员权限");
            res.setCount(0);
            return res;
        }
        List<UserVo> data = userMapper.findUserVo();
        res.setMsg("查询成功");
        res.setCode(0);
        res.setCount(data.size());
        res.setData(data);
        return res;
    }
}
