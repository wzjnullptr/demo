package com.example.controller;

import com.aliyun.oss.model.OSSObjectSummary;
import com.example.service.AliyunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/aliyun/oss")
@Controller
public class AliyunController {

    @Autowired
    private AliyunService aliyunService;

    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam MultipartFile file, @RequestParam String path){
        aliyunService.uploadFile(file,path);
    }

    @DeleteMapping("/deleteFile")
    public void deleteFile(@RequestParam String path){
        aliyunService.deleteFile(path);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<OSSObjectSummary> list() {
        List<OSSObjectSummary> list = aliyunService.list();
        return list;
    }
}
