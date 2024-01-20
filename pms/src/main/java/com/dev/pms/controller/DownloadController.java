package com.dev.pms.controller;

import com.dev.pms.domain.FileVo;
import com.dev.pms.service.FileService;
import com.dev.pms.service.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Controller
@RequiredArgsConstructor
public class DownloadController {

    private final FileService fileService;
    private final String uploadPath = Paths.get("C:", "dev", "upload-files").toString();

    @GetMapping("/post-detail/{postId}/files/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("postId") Long postId,
                                                 @PathVariable("fileId") Long fileId) throws MalformedURLException {
        FileVo fileById = fileService.getFileById(fileId);
        String saveName = fileById.getSaveName();
        String uploadDate = fileById.getUploadDate().format(DateTimeFormatter.ofPattern("yyMMdd")).toString();

        UrlResource resource = new UrlResource("file:" + uploadPath + "/" + uploadDate + "/" + saveName);

        log.info("download fileById = {}", fileById);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.inline()
                        .filename(saveName, StandardCharsets.UTF_8)
                        .build()
                        .toString())
                .body(resource);
    }
}
