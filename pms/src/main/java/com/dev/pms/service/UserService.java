package com.dev.pms.service;

import com.dev.pms.domain.UserVo;
import com.dev.pms.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserVo> getUserList() {
        return userMapper.getUserList();
    }

    public Long login(String email, String password) {
        UserVo userVo = userMapper.getUserByEmail(email);
        log.info("UserService: userInfo {}", userVo);
        if (userVo.getPassword().equals(password)) {
            return userVo.getUserId();
        }
        return null;
    }

    public void signup(UserVo userVo) {
        userMapper.insertUser(userVo);
    }

    public UserVo getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    public void modifyInfo(UserVo userVo) {
        userMapper.updateUser(userVo);
    }

    public void withdraw(Long id) {
        userMapper.deleteUser(id);
    }

    public int emailDuplicateCheck(UserVo userVo) {
        return userMapper.emailDuplicateCheck(userVo);
    }
}
