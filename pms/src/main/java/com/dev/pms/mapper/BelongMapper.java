package com.dev.pms.mapper;

import com.dev.pms.domain.BelongDto;
import com.dev.pms.domain.PermissionVo;
import com.dev.pms.domain.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BelongMapper {

    void joinGroup(Long userId, Long groupId);

    BelongDto checkBelongInfoByUser(Long userId, Long groupId);

    PermissionVo checkWritePermission(Long userId, Long groupId);

    PermissionVo checkManager(Long userId, Long groupId);

    Long checkPermissionReadPost(Long postId, Long userId);

    void grantAuthorityTrue(@Param("userId") Long userId, @Param("groupId") Long groupId);

    void grantAuthorityManager(@Param("userId") Long userId, @Param("groupId") Long groupId);

    UserVo getUserByGroup(Long groupId);

    void deleteUserByGroup(@Param("userId") Long userId, @Param("groupId") Long groupId);
}
