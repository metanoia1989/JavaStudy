package com.webdemo2.webdemo2.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
    // 绑定文件上传路径
    @Value("${upload-path}")
    private String uploadPath;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
    
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");     
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(
            oldName.lastIndexOf(".", oldName.length()));
        try {
            uploadFile.transferTo(new File(folder, newName));
            String filePath = request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort() + "/uploadFile/" + format + newName;
            return filePath + "," + folder;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败!";
    }
}
