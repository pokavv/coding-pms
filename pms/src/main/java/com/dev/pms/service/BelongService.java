package com.dev.pms.service;

import com.dev.pms.domain.BelongDto;
import com.dev.pms.domain.UserDto;
import com.dev.pms.mapper.BelongMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BelongService {

    @Autowired
    private BelongMapper belongMapper;

    public void joinGroup(Long userId, Long groupId) {
        belongMapper.joinGroup(userId, groupId);
        log.info("BelongService.joinGroup = userId: {}, groupId: {}", userId, groupId);
    }

    public BelongDto checkBelongInfoByUser(Long userId, Long groupId) {
        return belongMapper.checkBelongInfoByUser(userId, groupId);
    }
}
