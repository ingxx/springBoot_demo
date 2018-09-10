package com.ingxx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ingxx.dao.UserDao;
import com.ingxx.model.User;
import com.ingxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public PageInfo<User> page(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userDao.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
}
