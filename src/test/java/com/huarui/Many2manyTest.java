package com.huarui;

import com.huarui.dao.GroupMapper;
import com.huarui.dao.StudentMapper;
import com.huarui.entity.Group;
import com.huarui.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lihui on 2019/1/26.
 *  Mybatis 多对多
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class Many2manyTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Test
    public void testGetStudent(){
        Student student = studentMapper.getStudent(1L);
        System.out.println(student);
    }

    @Test
    public void testGetGroup(){
        Group group = groupMapper.getGroup(1);
        System.out.println(group);
    }


}
