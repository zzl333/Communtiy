package com.lixiangshequ.controller;

import com.lixiangshequ.entity.generator.UserGen;
import com.lixiangshequ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(UserGen user, HttpServletRequest request){
        if(user.getId() == null || user.getPassword() == null){
            request.setAttribute("msg", "账号或者密码为空!");
            return "/login";
        }
        user = userService.login(user);
        if(user == null) {
            request.setAttribute("msg", "账号或密码错误!");
            return "/login";
        }
        //放入Session
        request.getSession().setAttribute("user", user);
        user.setPassword(null);
        request.setAttribute("user", user);
        return "/index";
    }
}
