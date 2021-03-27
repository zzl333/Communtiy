package com.lixiangshequ.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lixiangshequ.entity.UserVo;
import com.lixiangshequ.entity.base.BaseUser;

import java.util.List;

public interface UserMapper extends BaseMapper<BaseUser> {

    List<UserVo> findUserVo();
}
