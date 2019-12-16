package com.louhwz.python.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class PythonController {

    @Value("${uploadpic.path}")
    private String uploadPicPath;

    @CrossOrigin
    @PostMapping("/upload")
    public String upload(HttpServletRequest req, @RequestParam(value = "file")MultipartFile file, Model model, RedirectAttributes redirectAttributes) throws Exception {
        // 存储图片到本地
        storePic(file);
        redirectAttributes.addFlashAttribute("message", "成功上传"+file.getOriginalFilename());
        model.addAttribute("picName", file.getOriginalFilename());
        System.out.println(req.getServletContext().getRealPath(""));
        System.out.println(file.getOriginalFilename());

        return "success";
    }
    private String storePic(MultipartFile file) throws Exception{
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {

            try(InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadPicPath + filename), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new Exception("失败！" + filename, e);
        }
        return filename;
    }
}
