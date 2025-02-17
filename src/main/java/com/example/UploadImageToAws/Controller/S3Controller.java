package com.example.UploadImageToAws.Controller;

import com.example.UploadImageToAws.Service.ImageUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/s3")
public class S3Controller {
    //uploadimage

    @Autowired
    private ImageUploader imageUploader;

    @PostMapping("/posts")
    public ResponseEntity<?> uploadImage(@RequestPart MultipartFile file){
        String uploadimage = imageUploader.uploadImage(file);
        return new ResponseEntity<>(uploadimage, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<String> allFiles(@RequestParam String type){
        List<String> strings = imageUploader.allFiles(type);
        return strings;
    }
}
