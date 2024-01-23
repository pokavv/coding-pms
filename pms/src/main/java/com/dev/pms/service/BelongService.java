package com.dev.pms.service;

import com.dev.pms.domain.*;
import com.dev.pms.mapper.BelongMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Long checkPermissionReadPost(Long postId, Long userId) {
        return belongMapper.checkPermissionReadPost(postId, userId);
    }

    public PermissionVo checkWritePermission(Long userId, Long groupId) {
        return belongMapper.checkWritePermission(userId, groupId);
    }

    public PermissionVo checkManager(Long userId, Long groupId) {
        return belongMapper.checkManager(userId, groupId);
    }

    public void grantAuthorityTrue(Long userId, Long groupId) {
        belongMapper.grantAuthorityTrue(userId, groupId);
    }

    public void grantAuthorityManager(Long userId, Long groupId) {
        belongMapper.grantAuthorityManager(userId, groupId);
    }

    public UserVo getUserByGroup(Long groupId) {
        return belongMapper.getUserByGroup(groupId);
    }

    public void deleteUserByGroup(Long userId, Long groupId) {
        belongMapper.deleteUserByGroup(userId, groupId);
    }

    public List<GroupMemberVo> getGroupMember(Long groupId) {
        return belongMapper.getGroupMember(groupId);
    }

    public List<GroupMemberVo> getGroupManager(Long groupId) {
        return belongMapper.getGroupManager(groupId);
    }

    public List<GroupMemberVo> getGroupJunior(Long groupId) {
        return belongMapper.getGroupJunior(groupId);
    }

    public void addBelongCreateUser(Long userId, Long groupId) {
        belongMapper.addBelongCreateUser(userId, groupId);
    }
}
