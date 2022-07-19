package com.nowcoder.community.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
//    private Cloudinary cloudinaryConfig;
    private Cloudinary cloudinary;


    public String uploadFile(MultipartFile file, Map options) {
//        File uploadedFile = convertMultiPartToFile(file);
//        Map uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, options);
//        return  uploadResult.get("url").toString();
        try {
            File uploadedFile = convertMultiPartToFile(file);
//            Map uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, options);
            Map uploadResult = cloudinary.uploader().upload(uploadedFile, options);
            return  uploadResult.get("url").toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}