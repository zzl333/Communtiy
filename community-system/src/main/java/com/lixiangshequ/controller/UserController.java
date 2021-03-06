package com.lixiangshequ.controller;

import com.lixiangshequ.config.PageResponse;
import com.lixiangshequ.config.ResponseMessage;
import com.lixiangshequ.entity.UserVo;
import com.lixiangshequ.entity.base.BaseUser;
import com.lixiangshequ.entity.base.BaseUserInfo;
import com.lixiangshequ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<BaseUser>{

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(BaseUser user, HttpServletRequest request){
        logger.info("/user/login:" + user.getCode());
        ResponseMessage<BaseUserInfo> res = userService.login(user);
        //放入Session
        if (res.getData() != null) {
            request.getSession().setAttribute("user", res.getData());
        }else {
            request.setAttribute("msg", res.getMsg());
        }
        return res.getUrl();
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        logger.info("/user/logout");
        request.getSession().removeAttribute("user");
        return "/login";
    }

    @RequestMapping("/find")
    @ResponseBody
    public PageResponse<UserVo> find(HttpServletRequest request) {
        logger.info("/u");
        return userService.find(request.getSession());
    }

}
