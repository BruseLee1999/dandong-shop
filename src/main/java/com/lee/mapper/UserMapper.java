package com.lee.mapper;

import com.lee.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User Sel(int id);
    User login(String username, String password);
    User findUserByName(String username);
    int register(String username, String password, String telephone, String date);
    int updatePasswordById(int id,String password);
    int updateUserInformation(int id, String username, String telephone, String address);
}

