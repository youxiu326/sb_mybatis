package com.huarui;

import com.huarui.dao.PostMapper;
import com.huarui.dao.UserMapper;
import com.huarui.entity.Post;
import com.huarui.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PostMapper postMapper;

    @Test
    public void test01(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void test02(){
        Post post = postMapper.selectByIdAndUser(4);
        System.out.println(post);
    }

    @Test
    public void test03(){
        int result = postMapper.addPost(4, "牛逼的标题", 1, new Date());
        System.out.println("===============================");
        System.out.println(result);
    }

    @Test
    public void test04(){
        User user = userMapper.selectByIdAndPost(1);
        System.out.println(user.getPosts());
    }

    /** 传递多个参数示例

     @Select("select id, name, age, gender from my_student")
     @Results({
     @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
     @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
     @Result(column="{age=age,gender=gender}", property="lunch",
     one=@One(select="com.example.demo.mapper.StudentMapper.getLunchByAgeAndGender")),
     })
     List<Student> selectAllAndLunch();

     @Select("select name from lunch where student_age = #{age} and student_gender = #{gender}")
     String getLunchByAgeAndGender(@Param("age") int age, @Param("gender") int gender);

     */

} 