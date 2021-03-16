package com.lixiangshequ.repository.mapper;

import com.lixiangshequ.entity.base.BaseActivity;
import com.lixiangshequ.repository.base.BaseActivityMapper;

import java.util.List;

public interface ActivityMapper extends BaseActivityMapper {

    List<BaseActivity> findAll();
}