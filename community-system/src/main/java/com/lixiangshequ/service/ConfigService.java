package com.lixiangshequ.service;

import com.lixiangshequ.config.PageResponse;
import com.lixiangshequ.config.ResponseMessage;
import com.lixiangshequ.entity.base.BaseConfig;
import com.lixiangshequ.repository.mapper.ConfigMapper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 字典服务
 *
 * @author 张祥麟
 * @Date 2021/3/19
 * @Version 1.0
 */
@Service
public class ConfigService extends BaseService<BaseConfig> {

    @Autowired
    UserService userService;

    @Autowired
    ConfigMapper configMapper;

    public PageResponse<BaseConfig> find(Integer type, HttpSession session) {
        PageResponse<BaseConfig> res = new PageResponse<>(1, null, null, null);
        if (!userService.isLogin(session)) {
            res.setMsg("请先登录");
            return res;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        res.setCode(0);
        res.setData(configMapper.selectByMap(map));
        return res;
    }
}
