package com.huarui.dao;

import com.huarui.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

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

    @Select({"select id,username from user where id=#{id}"})
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="username", property="username"),
            @Result(column="id", property="posts", javaType= List.class,
                    many=@Many(select="com.huarui.dao.PostMapper.selectByUserId"))
    })
    User selectByIdAndPost(Integer id);

}