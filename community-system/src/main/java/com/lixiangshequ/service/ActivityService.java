package com.lixiangshequ.service;

import com.lixiangshequ.config.PageResponse;
import com.lixiangshequ.config.ResponseMessage;
import com.lixiangshequ.entity.base.BaseActivity;
import com.lixiangshequ.entity.base.BaseUserInfo;
import com.lixiangshequ.repository.mapper.ActivityMapper;
import com.lixiangshequ.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class ActivityService extends BaseService<BaseActivity> {

    @Autowired
    ActivityMapper activityMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    /**
     * 查询所有活动
     *
     * @param session
     * @return
     */
    public PageResponse<BaseActivity> find(HttpSession session) {

        PageResponse<BaseActivity> res = new PageResponse<>();
        BaseUserInfo userInfo = (BaseUserInfo) session.getAttribute("user");
        if (userInfo == null || userInfo.getUid() == null) {
            res.setCode(404);
            res.setMsg("请先登录");
            return res;
        }
        //权限校验，不是管理员
        if (userMapper.selectById(userInfo.getUid()).getRole() != 2) {
            res.setMsg("您没有权限操作此页面");
            res.setCode(404);
            return res;
        }
        List<BaseActivity> all = activityMapper.selectByMap(new HashMap<>());
        res.setData(all);
        res.setCode(0);
        res.setMsg("加载成功");
        res.setCount(all.size());
        return res;
    }

    /**
     * 条件查询所有活动
     *
     * @param session
     * @param map
     * @return
     */
    public PageResponse<BaseActivity> findByCondition(HttpSession session, Map<String, Object> map) {
        logger.info("ActivityService.findByCondition");
        PageResponse<BaseActivity> res = new PageResponse<>();
        //权限校验
        if (!userService.isAdmin(session)) {
            res.setCode(404);
            res.setMsg("没有权限");
            return res;
        }
        List<BaseActivity> activities = activityMapper.selectByMap(map);
        res.setData(activities);
        res.setCode(0);
        res.setCount(activities.size());
        res.setMsg("成功");
        return res;
    }

    /**
     * 新增活动
     *
     * @return
     */
    public ResponseMessage<BaseActivity> addActivity(HttpSession session, BaseActivity activity) {

        ResponseMessage<BaseActivity> res = new ResponseMessage<>();
        //权限校验
        if (!userService.isAdmin(session)) {
            res.setMsg("没有权限");
            res.setSuccess(false);
            return res;
        }
        //数据校验
        if (!validate(activity)) {
            res.setMsg("请检查数据");
            res.setSuccess(false);
            return res;
        }
        //添加数据
        if (activityMapper.insert(activity) < 1) {
            res.setMsg("添加活动失败");
            res.setSuccess(false);
            return res;
        }
        //封装返回值
        res.setSuccess(true);
        res.setMsg("添加成功");
        return res;
    }


    /**
     * 校验数据
     *
     * @return
     */
    public boolean validate(BaseActivity activity) {


        return true;

    }

    /**
     * 添加活动
     *
     * @Author 张祥麟
     * @Date 2021/3/21
     * @Param
     * @Return
     */
    public ResponseMessage<BaseActivity> add(BaseActivity activity, HttpSession session) {
        ResponseMessage<BaseActivity> res = new ResponseMessage<>();
        if (!userService.isAdmin(session)) {
            res.setSuccess(false);
            res.setMsg("您不是管理员，请先登录");
            res.setUrl("redirect:/page/login");
            return res;
        }

        activity.setCreateBy(userService.getUserInfo(session).getName());
        activity.setCreated(new Date());


        if (activityMapper.insert(activity) == 0) {
            res.setSuccess(false);
            res.setMsg("添加失败请检查数据");
            res.setMsg("redirect:/page/error");
            return res;
        }

        res.setSuccess(true);
        res.setUrl("redirect:/page/admin/index");
        res.setMsg("添加成功");
        return res;
    }

    /**
     * 根据id删除活动
     *
     * @Author 张祥麟
     * @Date 2021/3/24
     * @Param
     * @Return
     */
    public ResponseMessage delete(HttpSession session, Integer id) {
        ResponseMessage res = new ResponseMessage();
        //登录权限校验
        if (!userService.isAdmin(session)) {
            res.setMsg("请先登录");
            res.setSuccess(false);
            res.setUrl("redirect:/page/login");
            return res;
        }
        BaseActivity baseActivity = activityMapper.selectById(id);
        if (baseActivity == null) {
            res.setMsg("删除的数据不存在，请刷新");
            res.setSuccess(false);
            res.setUrl("redirect:/page/admin/index");
            return res;
        }
        //[TODO]并发情况下会出现重复删除和删除失误的情况，建议使用乐观锁
        activityMapper.deleteById(id);

        res.setUrl("redirect:/page/admin/index");
        res.setSuccess(true);
        res.setMsg("删除成功");
        return res;
    }

    /**
     * 批量删除活动
     *
     * @author 张祥麟
     * @Date 2021/3/24
     * @Version 1.0
     */
    public ResponseMessage deleteBatch(HttpSession session, Integer[] ids) {
        ResponseMessage res = new ResponseMessage();
        //登录权限校验
        if (!userService.isAdmin(session)) {
            res.setMsg("请先登录");
            res.setSuccess(false);
            res.setUrl("redirect:/page/login");
        }
        //[TODO] 使用Collections.addAll构造list，不要使用Arrays.asList(),产生的是Array内部类很多方法并不能用
        List<Integer> idsList = new ArrayList<>();
        Collections.addAll(idsList, ids);
        if (ids.length != activityMapper.deleteBatchIds(idsList)) {
            res.setMsg("部分数据删除失败");
            res.setSuccess(false);
        } else {
            res.setSuccess(true);
            res.setMsg("删除成功");
        }

        res.setUrl("/admin/index");
        return res;
    }

}
