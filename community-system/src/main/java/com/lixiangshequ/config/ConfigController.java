package com.lixiangshequ.config;

import com.lixiangshequ.controller.BaseController;
import com.lixiangshequ.entity.base.BaseConfig;
import com.lixiangshequ.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 数据字典服务
 *
 * @author 张祥麟
 * @Date 2021/3/19
 * @Version 1.0
 */
@Controller
@RequestMapping("/config")
public class ConfigController extends BaseController<BaseConfig> {

    @Autowired
    ConfigService configService;


    @RequestMapping("/find/{type}")
    @ResponseBody
    public PageResponse<BaseConfig> find(@PathVariable Integer type, HttpServletRequest request) {
        return configService.find(type, request.getSession());
    }
}
