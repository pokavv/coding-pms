package com.dev.pms.service;

import com.dev.pms.domain.UserVo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyUserDetailService implements UserDetailsService {

    private final UserService userService;

    public MyUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String insertUserEmail) throws UsernameNotFoundException {
        Optional<UserVo> userByEmail = userService.getUserByEmail(insertUserEmail);
        UserVo userVo = userByEmail.orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 회원입니다."));

        return User.builder()
                .username(userVo.getEmail())
                .password(userVo.getPassword())
                .build();
    }
}
