package com.kuang.service;

import com.kuang.pojo.Books;
import com.kuang.pojo.User;

import java.util.List;

public interface UserService {
    int addUser(User user);
    int deleteUserByAccount(String userAccount);
    int updateUser(User user);
    User queryUserByAccount(String userAccount);
    List<User> queryAllUser();
}
