package com.bjsxt.consumer.service.impl;

import com.bjsxt.consumer.service.FileUploadService;
import com.bjsxt.utils.FtpUtils;
import com.bjsxt.utils.IDUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author lvyelanshan
 * @create 2019-10-21 16:58
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${FTP_HOST}")
    private String FTP_HOST;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_PATH}")
    private String FTP_PATH;
    @Value("${IMAGE_HTTP_PATH}")
    private String IMAGE_HTTP_PATH;

    @Override
    public String picUpload(MultipartFile multipartFile) {
        /*获得文件的原始名*/
        String oriName = multipartFile.getOriginalFilename();
        /*截取文件的后缀名*/
        String ext = oriName.substring(oriName.lastIndexOf("."));
        /*通过工具类随机生成文件名加上原始文件名的后缀拼接成一个完整的文件名*/
        String fileName = IDUtils.genImageName() + ext;
        try {
            FtpUtils.uploadFile(FTP_HOST, FTP_PORT, FTP_USERNAME,
                    FTP_PASSWORD, FTP_PATH,
                    fileName, multipartFile.getInputStream());
            //返回一个完整的图片路径名
            return IMAGE_HTTP_PATH + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
