package com.dev.pms.repository.user;

import com.dev.pms.domain.user.User;
import com.dev.pms.domain.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        userMapper.save(user);
        return user;
    }

    @Override
    public void update(Long id, UserUpdateDto updateDto) {
        userMapper.update(id, updateDto);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userMapper.findById(userId);
    }

    @Override
    public List<User> findAll(UserSearchCond cond) {
        return userMapper.findAll(cond);
    }

    @Override
    public void delete(Long userId) {
        userMapper.delete(userId);
    }
}
