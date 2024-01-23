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

    public List<GroupVo> getGroupByUser(Long userId) {
        return groupMapper.getGroupByUser(userId);
    }

    public List<GroupVo> getGroupAll(GroupSearchCond cond) {
        return groupMapper.getGroupAll(cond);
    }

    public GroupVo getGroupById(Long groupId) {
        return groupMapper.getGroupById(groupId);
    }

    public Boolean checkAuthManagerBySessionId(Long groupId, Long userId) {
        return groupMapper.checkAuthManagerBySessionId(groupId, userId);
    }

    public void createGroup(String groupName, String groupDescription, String groupAim) {
        groupMapper.createGroup(groupName, groupDescription, groupAim);
    }

    public Long getRecentAddGroupId() {
        return groupMapper.getRecentAddGroupId();
    }
}
