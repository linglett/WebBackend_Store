package com.kuang.dao;

import com.kuang.pojo.Books;
import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper {
    //增加一个User
    int addUser(User user);
    //根据userAccount删除一个User
    int deleteUserByAccount(String userAccount);
    //更新User
    int updateUser(User user);
    //根据userAccount查询,返回一个User
    User queryUserByAccount(String userAccount);
    //查询全部User,返回list集合
    List<User> queryAllUser();
}
