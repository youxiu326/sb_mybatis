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
        Post post = postMapper.selectByIdAndUser(1);
        System.out.println(post);
    }

    @Test
    public void test03(){
        int result = postMapper.addPost(4, "牛逼的标题", 1, new Date());
        System.out.println("===============================");
        System.out.println(result);
    }

} 