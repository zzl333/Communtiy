package com.lixiangshequ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageUtilsController {
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
}
