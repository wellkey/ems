package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //登录使用
    User login(User user);

    //展示所有
    List<User> selectAll();
}
