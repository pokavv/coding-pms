package com.dev.pms.repository.user;

import com.dev.pms.domain.user.User;
import com.dev.pms.domain.user.UserUpdateDto;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    void update(Long id, UserUpdateDto updateDto);

    Optional<User> findById(Long userId);

    List<User> findAll(UserSearchCond cond);

    void delete(Long userId);
}
