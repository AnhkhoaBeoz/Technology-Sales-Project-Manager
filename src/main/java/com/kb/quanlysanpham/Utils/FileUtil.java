package com.kb.quanlysanpham.Utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class FileUtil {

    public static String cleanFileName(MultipartFile file) {
        return StringUtils.cleanPath(file.getOriginalFilename());
    }

    public static boolean isValidFile(String fileName) {
        return !fileName.contains("..");
    }

    public static String encodeFileToBase64(MultipartFile file) {
        try {
            return Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
