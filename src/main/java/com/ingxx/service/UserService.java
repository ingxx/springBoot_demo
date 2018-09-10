package com.ingxx.service;

import com.github.pagehelper.PageInfo;
import com.ingxx.model.User;

import java.util.List;

public interface UserService {
    /**
     * 获取所有用户
     * @return
     */
    List<User> selectAll();

    /**
     * 分页
     * @param pageNum 当前页码
     * @param pageSize 每页条数
     * @return
     */
    PageInfo<User> page(int pageNum, int pageSize);
}
