package com.dev.pms.service;

import com.dev.pms.domain.UserVo;
import com.dev.pms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserVo> getUserList() {
        List<UserVo> userList = userMapper.getUserList();
        return userList;
    }

    public Long login(String email, String password) {
        UserVo userVo = userMapper.getUserByEmail(email);
        if (userVo.getPassword().equals(password)) {
            return userVo.getId();
        }
        return null;
    }

    public void signup(UserVo userVo) {
        userMapper.insertUser(userVo);
    }

    public UserVo getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    public UserVo getUserById(Long id) {
        UserVo userVo = userMapper.getUserById(id);
        return userVo;
    }

    public void modifyInfo(UserVo userVo) {
        userMapper.updateUser(userVo);
    }

    public void withdraw(Long id) {
        userMapper.deleteUser(id);
    }
}
