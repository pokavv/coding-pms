package com.dev.pms.service;

import com.dev.pms.domain.GroupSearchCond;
import com.dev.pms.domain.GroupVo;
import com.dev.pms.mapper.GroupMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GroupService {

    @Autowired
    private GroupMapper groupMapper;

    public List<GroupVo> getGroupByUer(Long userId) {
        return groupMapper.getGroupByUser(userId);
    }

    public List<GroupVo> getGroupAll(GroupSearchCond cond) {
        return groupMapper.getGroupAll(cond);
    }
}
