package com.dev.pms.mapper;

import com.dev.pms.domain.GroupSearchCond;
import com.dev.pms.domain.GroupVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupMapper {

    List<GroupVo> getGroupByUser(Long userId);

    List<GroupVo> getGroupAll(GroupSearchCond groupSearchCond);

    GroupVo getGroupById(Long groupId);

    Boolean checkAuthManagerBySessionId(@Param("groupId") Long groupId, @Param("userId") Long userId);
}
