package com.huarui.dao;

import com.huarui.entity.StudentGroup;

public interface StudentGroupMapper {
    int insert(StudentGroup record);

    int insertSelective(StudentGroup record);
}