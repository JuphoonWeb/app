package com.juphoon.app.controller;

import com.juphoon.app.common.ServerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author rongbin.huang
 * @create 2018-10-12 上午10:22
 **/
@RestController
public class FileController {

    @Value("${appFilePath}")
    private String appFilePath;

    @Value("${appDownloadUrl}")
    private String appDownloadUrl;

    @RequestMapping("/uploadFile")
    public ServerResponse uploadFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String fileName = originalFilename.split("\\.")[0] + "-" + System.currentTimeMillis() + "." +
                originalFilename.split("\\.")[1];
        File newFile = new File(appFilePath + File.separator + fileName);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        return ServerResponse.success(appDownloadUrl + fileName);
    }

}
