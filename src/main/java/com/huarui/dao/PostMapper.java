package com.huarui.dao;

import com.huarui.entity.Post;
import com.huarui.entity.User;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.Date;
import java.util.List;

/**
 * 启用二级缓存
 */
@CacheNamespace(implementation = com.huarui.cache.MybatisRedisCache.class )
public interface PostMapper {
    int deleteByPrimaryKey(Integer postId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer postId);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    List<Post> getPosts(Integer postId);


    /*******************************我是分割线 注解方式查询 **********************************/


    @Select({"select post_id,user_id from post where post_id=#{id}"})
    @Results({
            @Result(column = "post_id",property = "postId",jdbcType= JdbcType.INTEGER,id = true),
            @Result(column = "user_id",property = "user",javaType=User.class,
            one = @One(select = "com.huarui.dao.UserMapper.selectByPrimaryKey"))
    })
    Post selectByIdAndUser(Integer id);

    @Insert("insert into post (post_id, title, user_id,created) values (#{postId}, #{title}, #{userId},#{created});")
    public int addPost(@Param("postId") int postId, @Param("title") String title, @Param("userId") int userId, @Param("created") Date created);

    @Select({"select * from post where user_id=#{userId}"})
    @Results(
            @Result(column = "post_id",property = "postId",jdbcType = JdbcType.INTEGER,id = true)
    )
    public List<Post> selectByUserId(Integer userId);
}