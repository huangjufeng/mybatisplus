package com.mywebhi.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mywebhi.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: jeff
 * @date: 2020-07-24 16:42
 * @Description:
 * @version: 1.0.0
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    public User selectById1(@Param("id")int id);
}
