package com.dev.pms.mapper;

import com.dev.pms.domain.FileDto;
import com.dev.pms.domain.FileVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileMapper {

    List<FileVo> getFileByPost(Long postId);

    void insertFile(@Param("postId") Long postId, @Param("files") List<FileDto> fileDtoList);

    void deleteFile(Long fileId);
}