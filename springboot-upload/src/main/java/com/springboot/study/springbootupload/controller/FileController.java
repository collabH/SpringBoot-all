package com.springboot.study.springbootupload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * 文件上传下载Controller
 *
 * @author huang
 * @PACKAGE_NAME com.springboot.study.springbootupload.controller
 * @PROJECT_NAME springboot
 * @date 2018/12/28
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping(value = "/upload")
    public String getFile(@RequestParam("myfile") MultipartFile file) {
        logger.info("文件名:{}", file.getOriginalFilename());
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "F:\\upload\\";
        fileName = filePath + UUID.randomUUID() + fileName;
        File dest = new File(fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws FileNotFoundException {
        File file = new File("C:\\Users\\h1261\\Pictures\\back.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        response.setContentType("application/gorce-download");
        response.addHeader("Content-disposition", "attachment;fileName=back.jpg");
        try {
            OutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
