package com.dev.pms.service;

import com.dev.pms.domain.FileDto;
import com.dev.pms.domain.FileVo;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileUtils {

    private final String uploadPath = Paths.get("C:", "dev", "upload-files").toString();

    public List<FileDto> uploadFiles(List<MultipartFile> multipartFiles) {
        List<FileDto> fileDtoList = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.isEmpty()) {
                continue;
            }
            fileDtoList.add(uploadFile(multipartFile));
        }
        return fileDtoList;
    }

    public FileDto uploadFile(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return null;
        }
        String saveFileName = generateSaveFileName(multipartFile.getOriginalFilename());
        String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd")).toString();
        String uploadPath = getUploadPath(today) + File.separator + saveFileName;
        File uploadFile = new File(uploadPath);

        try {
            multipartFile.transferTo(uploadFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return FileDto.builder()
                .originalName(multipartFile.getOriginalFilename())
                .saveName(saveFileName)
                .fileSize(multipartFile.getSize())
                .build();
    }

    public void deleteFiles(List<FileDto> files) {
        if (CollectionUtils.isEmpty(files)) {
            return;
        }
        for (FileDto file : files) {
            String uploadDate = file.getUploadDate()
                    .toLocalDate().format(DateTimeFormatter.ofPattern("yyMMdd"));
            deleteFile(uploadDate, file.getSaveName());
        }
    }

    private void deleteFile(String addPath, String fileName) {
        String filePath = Paths.get(uploadPath, addPath, fileName).toString();
        deleteFile(filePath);
    }

    private void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    private String generateSaveFileName(String fileName) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = StringUtils.getFilenameExtension(fileName);
        return uuid + "." + extension;
    }

    private String getUploadPath() {
        return makeDirectories(uploadPath);
    }

    private String getUploadPath(String addPath) {
        return makeDirectories(uploadPath + File.separator + addPath);
    }

    private String makeDirectories(String path) {
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        return fileDir.getPath();
    }
}
