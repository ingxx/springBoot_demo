package com.ingxx.dao;

import com.ingxx.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();
}
