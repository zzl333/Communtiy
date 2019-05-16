package com.lixiangshequ.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public String index(){
        return "../static/html/index";
    }

    @RequestMapping("/clerk/getManagementMenu")
    public String managementMenu(){
        return "../static/html/management/index";
    }
}
