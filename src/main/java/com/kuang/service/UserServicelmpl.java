package com.kuang.service;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.Books;
import com.kuang.pojo.User;

import java.util.List;

public class UserServicelmpl implements UserService{
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper){
        this.userMapper=userMapper;
    }
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
    public int deleteUserByAccount(String userAccount) {
        return userMapper.deleteUserByAccount(userAccount);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
    public User queryUserByAccount(String userAccount) {
        return userMapper.queryUserByAccount(userAccount);
    }
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }
}
