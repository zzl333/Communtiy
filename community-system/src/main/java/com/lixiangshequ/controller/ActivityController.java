package com.lixiangshequ.controller;

import com.lixiangshequ.config.PageResponse;
import com.lixiangshequ.config.ResponseMessage;
import com.lixiangshequ.entity.base.BaseActivity;
import com.lixiangshequ.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/add")
    public String add(BaseActivity activity, HttpServletRequest request) {
        logger.info("add activity");
        ResponseMessage<BaseActivity> add = activityService.add(activity, request.getSession());
        return add.getUrl();
    }


    //    deleteById
    @RequestMapping("/deleteById/{id}")
    @ResponseBody
    public ResponseMessage deleteById(HttpServletRequest request, @PathVariable("id") Integer id) {
        logger.info("delete activity by id");
        return activityService.delete(request.getSession(), id);
    }

    /**
     * 批量删除接口
     *
     * @Author 张祥麟
     * @Date 2021/3/24
     * @Param
     * @Return
     */
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseMessage deleteBatch(HttpServletRequest request, @RequestBody Integer[] ids) {
        logger.info("deleteBatch activity by ids");
        return activityService.deleteBatch(request.getSession(), ids);
    }

}
