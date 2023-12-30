package com.dev.pms.repository.user;

import com.dev.pms.domain.user.User;
import com.dev.pms.domain.user.UserUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    void save(User user);

    void update(@Param("userId") Long userId,
                @Param("updateParam")UserUpdateDto updateDto);

    Optional<User> findById(Long userId);

    List<User> findAll(UserSearchCond cond);

    void delete(Long userId);
}
