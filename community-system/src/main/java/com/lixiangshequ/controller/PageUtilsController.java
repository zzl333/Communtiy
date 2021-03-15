package com.lixiangshequ.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/page")
public class PageUtilsController extends BaseController{
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

}
