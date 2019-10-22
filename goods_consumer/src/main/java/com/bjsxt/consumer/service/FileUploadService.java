package com.bjsxt.consumer.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author lvyelanshan
 * @create 2019-10-21 16:57
 */
public interface FileUploadService {
    String picUpload(MultipartFile multipartFile);
}
