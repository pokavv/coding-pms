package com.dev.pms.mapper;

import com.dev.pms.domain.BelongDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BelongMapper {

    void joinGroup(Long userId, Long groupId);

    BelongDto checkBelongInfoByUser(Long userId, Long groupId);
}
