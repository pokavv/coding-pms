package com.dev.pms.mapper;

import com.dev.pms.domain.BelongDto;
import com.dev.pms.domain.PermissionVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BelongMapper {

    void joinGroup(Long userId, Long groupId);

    BelongDto checkBelongInfoByUser(Long userId, Long groupId);

    PermissionVo checkWritePermission(Long userId, Long groupId);

    PermissionVo checkManager(Long userId, Long groupId);
}
