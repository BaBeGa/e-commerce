package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.exception.TokenNotFoundException;
import com.th.ac.ku.kps.cpe.ecommerce.model.upload.UploadFileResponse;
import com.th.ac.ku.kps.cpe.ecommerce.repository.ProductPicRepository;

import com.th.ac.ku.kps.cpe.ecommerce.service.UploadFileService;
import com.th.ac.ku.kps.cpe.ecommerce.service.UploadFileServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@RestController
@RequestMapping(path = "/api/ecom")
public class UploadAndDownloadController {
    private static final String UPLOAD_FOLDER = "D://upload//";
    @Autowired
    private ProductPicRepository productPicRepository;

    @PostMapping("/upload")
    public UploadFileResponse upload(@RequestHeader (required = false) String token,
                                     @RequestParam("file") MultipartFile file,
                                     @RequestParam(value = "id_product", required = false) Integer id_product) {
        if (token == null || token.isEmpty()) {
           throw new TokenNotFoundException("Token can't be null");
        }
        if (id_product == null) {
            throw new TokenNotFoundException("id_product is required");
        }
        UploadFileService uploadFileService = new UploadFileServiceImpl(productPicRepository);
        return uploadFileService.uploadResponse(token, id_product, file, UPLOAD_FOLDER);
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam String filename) throws IOException {
        MediaType mediaType = MediaType.IMAGE_PNG;
        System.out.println("fileName: " + filename);
        System.out.println("mediaType: " + mediaType);

        File file = new File(UPLOAD_FOLDER + filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                .contentType(mediaType)
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);
    }
}
