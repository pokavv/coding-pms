package com.dev.pms.mapper;

import com.dev.pms.domain.GroupVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMapper {

    List<GroupVo> getGroupByUser(Long userId);
}
