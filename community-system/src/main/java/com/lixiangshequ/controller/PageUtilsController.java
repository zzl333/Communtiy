package com.lixiangshequ.controller;

import com.lixiangshequ.entity.base.BaseUserInfo;
import com.lixiangshequ.service.ActivityService;
import com.lixiangshequ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/page")
public class PageUtilsController extends BaseController{

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @RequestMapping("/top")
    public String getTop() {
        return "/top";
    }

    @RequestMapping("/carousel")
    public String getCarousel() {
        return "/carousel";
    }

    @RequestMapping("/activity")
    public String getActivity() {
        return "/activity";
    }

    @RequestMapping("/foot")
    public String getFoot() {
        return "/foot";
    }

    @RequestMapping("/login")
    public String getLogin() {
        return "/login";
    }

    @RequestMapping("/activityManager")
    public String activityManager() {
        return "/admin/activityManager";
    }

    @RequestMapping("/addDialog")
    public String addDialog() {
        return "/admin/addDialog";
    }

    @RequestMapping("/editDialog")
    public String editDialog() {
        return "/admin/editDialog";
    }

    @RequestMapping("/admin/index")
    public String adminIndex(HttpServletRequest request) {
        BaseUserInfo userInfo = userService.getUserInfo(request.getSession());
        if (userInfo != null)
            request.setAttribute("user", userInfo);
        return "/admin/index";
    }

    @RequestMapping("/error")
    public String error() {
        return "/error";
    }

    @RequestMapping("/userManager")
    public String userManager() {
        return "/admin/userManager";
    }

    //'/page/changeUser'
    @RequestMapping("/userManager")
    public String changeUser() {
        return "/admin/changeUser";
    }
}
