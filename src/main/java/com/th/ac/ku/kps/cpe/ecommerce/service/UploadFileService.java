package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.upload.UploadFileResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UploadFileService {
    UploadFileResponse uploadResponse(String token, Integer id_product, MultipartFile file, String UPLOAD_FOLDER);
}
