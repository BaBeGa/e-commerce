package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.exception.TokenNotFoundException;
import com.th.ac.ku.kps.cpe.ecommerce.model.upload.UploadFileResponse;
import com.th.ac.ku.kps.cpe.ecommerce.repository.*;

import com.th.ac.ku.kps.cpe.ecommerce.service.UploadFileService;
import com.th.ac.ku.kps.cpe.ecommerce.service.UploadFileServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(path = "/ecom/api/eshop")
public class UploadAndDownloadController {
    public static final String UPLOAD_FOLDER = "//var//www//html//e-commerce_01//eshop//"; // //var//www//html//e-commerce_01//eshop//pic_product//
    @Autowired
    private ProductPicRepository productPicRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ShopHasProductRepository shopHasProductRepository;
    @Autowired
    private CommentProductRepository commentProductRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public UploadFileResponse upload(@RequestHeader (required = false) String token,
                                     @RequestParam("file") MultipartFile file,
                                     @RequestParam(value = "id_product", required = false) Integer id_product,
                                     @RequestParam(value = "id_comment", required = false) Integer id_comment) {
        if (token == null || token.isEmpty()) {
           throw new TokenNotFoundException("Token can't be null");
        }
        if (id_product == null && id_comment == null) {
            throw new TokenNotFoundException("id_product or id_comment required");
        }
        if (id_product != null && id_comment != null) {
            throw new TokenNotFoundException("Can input only one parameter");
        }
        UploadFileService uploadFileService = new UploadFileServiceImpl(productPicRepository, userRepository, shopRepository ,shopHasProductRepository, commentProductRepository);
        String type;
        if (id_product != null)  {
            type = "product";
            return uploadFileService.uploadResponse(token, id_product, file, UPLOAD_FOLDER, type);
        }
        else {
            type = "comment";
            return uploadFileService.uploadResponse(token, id_comment, file, UPLOAD_FOLDER, type);
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/download")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam(value = "id_product", required = false) String id_product,
                                                            @RequestParam(value = "id_comment", required = false) String id_comment,
                                                            @RequestParam String filename) throws IOException {
        MediaType mediaType = MediaType.IMAGE_PNG;
        if (id_product != null && id_comment != null) {
            throw new TokenNotFoundException("Can input only one parameter");
        }
        if (id_product == null && id_comment == null) {
            throw new TokenNotFoundException("id_product or id_comment required");
        }
        File file;
        if (id_product != null) {
            file = new File(UPLOAD_FOLDER + "//pic_product//" + id_product + "//" + filename);
        }
        else {
            file = new File(UPLOAD_FOLDER + "//pic_comment//" + id_comment + "//" + filename);
        }
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