package com.huarui.dao;

import com.huarui.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUser(Integer id);

    User getUser2(Integer id);

    /*******************************我是分割线 注解方式查询 **********************************/

    @Select({"select id,username from user where id=#{id}"})
    User selectById(Integer id);




}