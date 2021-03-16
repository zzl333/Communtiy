package com.lixiangshequ.controller;

import com.lixiangshequ.config.PageResponse;
import com.lixiangshequ.entity.base.BaseActivity;
import com.lixiangshequ.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @RequestMapping("find")
    @ResponseBody
    public PageResponse<BaseActivity> find(HttpServletRequest request) {
        return  activityService.find(request.getSession());
    }
}
