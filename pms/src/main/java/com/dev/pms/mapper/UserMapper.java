package com.dev.pms.mapper;

import com.dev.pms.domain.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    List<UserVo> getUserList();

    Optional<UserVo> getUserByEmail(String email);

    void insertUser(UserVo userVo);

    UserVo getUserById(Long id);

    void updateUser(UserVo userVo);

    void deleteUser(Long id);
}
