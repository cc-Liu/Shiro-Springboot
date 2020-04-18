package com.lc.service;

import com.lc.entity.User;
import com.lc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selecByName(String name){
        return userMapper.selectName(name);
    }

    public List<String> selectUserRole(String username,String password){
        return  userMapper.getUserRole(username,password);
    }
}
