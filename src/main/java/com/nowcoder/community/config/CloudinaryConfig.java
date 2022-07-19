package com.nowcoder.community.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
//@Component
public class CloudinaryConfig {

    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    @Value("${cloudinary.api_key}")
    private String apiKey;

    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    private Cloudinary cloudinary;


    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = null;
        Map config = new HashMap();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }

//    public CloudinaryConfig() {
//        Cloudinary cloudinary = null;
//        Map config = new HashMap();
//        config.put("cloud_name", cloudName);
//        config.put("api_key", apiKey);
//        config.put("api_secret", apiSecret);
//        cloudinary = new Cloudinary(config);
//        return cloudinary;
//    }

//    public Map upload(Object file, Map options){
//        try {
//            return cloudinary.uploader().upload(file, options);
//        }catch(IOException e) {
//            e.printStackTrace();
//            return null;
//
//        }
}
