package com.lixiangshequ.service;

import com.lixiangshequ.config.PageResponse;
import com.lixiangshequ.config.ResponseMessage;
import com.lixiangshequ.entity.base.BaseActivity;
import com.lixiangshequ.entity.base.BaseUserInfo;
import com.lixiangshequ.repository.mapper.ActivityMapper;
import com.lixiangshequ.repository.mapper.UserMapper;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;

@Service
public class ActivityService extends BaseService<BaseActivity> {

    @Autowired
    ActivityMapper activityMapper;

    @Autowired
    UserMapper userMapper;

    public PageResponse<BaseActivity> find(HttpSession session) {

        PageResponse<BaseActivity> res = new PageResponse<>();
        BaseUserInfo userInfo = (BaseUserInfo) session.getAttribute("user");
        if(userInfo == null || userInfo.getUid() == null) {
            res.setCode(404);
            res.setMsg("请先登录");
            return res;
        }
        //权限校验，不是管理员
        if (userMapper.selectByPrimaryKey(userInfo.getUid()).getRole() != 2){
            res.setMsg("您没有权限操作此页面");
            res.setCode(404);
            return res;
        }
        List<BaseActivity> all = activityMapper.findAll();
        res.setData(all);
        res.setCode(0);
        res.setMsg("加载成功");
        res.setCount(all.size());
        return res;
    }

}
