package com.dev.pms.service;

import com.dev.pms.domain.FileDto;
import com.dev.pms.domain.FileVo;
import com.dev.pms.mapper.FileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class FileService {

    @Autowired
    private FileMapper fileMapper;

    public List<FileVo> getFileByPost(Long postId) {
        return fileMapper.getFileByPost(postId);
    }

    public FileVo getFileById(Long fileId) {
        return fileMapper.getFileById(fileId);
    }

    public void insertFile(Long postId, List<FileDto> files) {
        if (CollectionUtils.isEmpty(files)) {
            return;
        }
        for (FileDto file : files) {
            file.setUploadDate(LocalDateTime.now());
            file.setPostId(file.getPostId());
        }
        fileMapper.insertFile(postId, files);
    }

    public void deleteFile(Long postId) {
        fileMapper.deleteFile(postId);
    }
}
