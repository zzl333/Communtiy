package com.lixiangshequ.controller;

import com.lixiangshequ.config.PageResponse;
import com.lixiangshequ.entity.base.BaseActivity;
import com.lixiangshequ.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("activity")
public class ActivityController extends BaseController<BaseActivity> {

    @Autowired
    ActivityService activityService;

    @RequestMapping("find")
    @ResponseBody
    public PageResponse<BaseActivity> find(HttpServletRequest request) {
        logger.info("find all activity");
        return  activityService.find(request.getSession());
    }

    @RequestMapping("findbyCondition")
    @ResponseBody
    public PageResponse<BaseActivity> findbyCondition(HttpServletRequest request, Map<String, Object> map) {
        logger.info("find activity by condition");
        return activityService.findByCondition(request.getSession(), map);
    }


}
