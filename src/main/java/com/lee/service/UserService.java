package com.lee.service;

import com.lee.mapper.UserMapper;
import com.lee.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User Sel(int id){
        return userMapper.Sel(id);
    }

    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    public int register(String username, String password, String telephone, String date) {
        return userMapper.register(username, password, telephone, date);
    }

    public User findUserByName(String username){return userMapper.findUserByName(username);}

    public int updateUserInformation(int id, String username, String telephone, String address){
        return userMapper.updateUserInformation(id, username, telephone, address);
    }

    public int updatePasswordById(int id, String password){
        return userMapper.updatePasswordById(id,password);
    }

}
