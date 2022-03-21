package com.example.service;

import com.aliyun.oss.model.OSSObjectSummary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * 阿里云文件上传接口
 */
public interface AliyunService {
    String uploadFile(MultipartFile file, String storagePath);

    String deleteFile(String path);

    List<OSSObjectSummary> list();
}
