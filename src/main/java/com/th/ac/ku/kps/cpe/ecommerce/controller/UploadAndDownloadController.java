package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.exception.TokenNotFoundException;
import com.th.ac.ku.kps.cpe.ecommerce.model.RatingProductPicEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductPicEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.upload.DeleteFileResponse;
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
    private RatingProductPicRepository ratingProductPicRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public UploadFileResponse upload(@RequestHeader (required = false) String token,
                                     @RequestParam("file") MultipartFile file,
                                     @RequestParam(value = "id_product", required = false) Integer id_product,
                                     @RequestParam(value = "id_rating_product", required = false) Integer id_rating_product) {
        if (token == null || token.isEmpty()) {
           throw new TokenNotFoundException("Token can't be null");
        }
        if (id_product == null && id_rating_product == null) {
            throw new TokenNotFoundException("id_product or id_rating_product required");
        }
        if (id_product != null && id_rating_product != null) {
            throw new TokenNotFoundException("Can input only one parameter");
        }
        UploadFileService uploadFileService = new UploadFileServiceImpl(productPicRepository, userRepository, shopRepository ,shopHasProductRepository, ratingProductPicRepository);
        String type;
        if (id_product != null)  {
            type = "product";
            return uploadFileService.uploadResponse(token, id_product, file, UPLOAD_FOLDER, type);
        }
        else {
            type = "comment";
            return uploadFileService.uploadResponse(token, id_rating_product, file, UPLOAD_FOLDER, type);
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/download")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam(value = "id_product", required = false) String id_product,
                                                            @RequestParam(value = "id_rating_product", required = false) String id_rating_product,
                                                            @RequestParam String filename) throws IOException {
        MediaType mediaType = MediaType.IMAGE_PNG;
        if (id_product != null && id_rating_product != null) {
            throw new TokenNotFoundException("Can input only one parameter");
        }
        if (id_product == null && id_rating_product == null) {
            throw new TokenNotFoundException("id_product or id_rating_product required");
        }
        File file;
        if (id_product != null) {
            file = new File(UPLOAD_FOLDER + "//pic_product//" + id_product + "//" + filename);
        }
        else {
            file = new File(UPLOAD_FOLDER + "//pic_rating_product//" + id_rating_product + "//" + filename);
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

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletefile")
    public DeleteFileResponse deleteFile(@RequestHeader (required = false) String token,
                                         @RequestParam(value = "id_product", required = false) String id_product,
                                         @RequestParam(value = "id_rating_product", required = false) String id_rating_product,
                                         @RequestParam String filename) {
        DeleteFileResponse response = new DeleteFileResponse();
        if (token == null || token.isEmpty()) {
            throw new TokenNotFoundException("Token can't be null");
        }
        if (id_product != null && id_rating_product != null) {
            throw new TokenNotFoundException("Can input only one parameter");
        }
        if (id_product == null && id_rating_product == null) {
            throw new TokenNotFoundException("id_product or id_rating_product required");
        }
        File file;
        if (id_product != null) {
            file = new File(UPLOAD_FOLDER + "//pic_product//" + id_product + "//" + filename);
            ProductPicEntity productPic = productPicRepository.findByPicProduct(filename);
            if (productPic == null) {
                response.setStatus(404);
                response.setMsg("Fail to delete file. File not found");
                return response;
            }
            productPicRepository.delete(productPic);
        }
        else {
            file = new File(UPLOAD_FOLDER + "//pic_rating_product//" + id_rating_product + "//" + filename);
            RatingProductPicEntity ratingProductPic = ratingProductPicRepository.findByContentPic(filename);
            if (ratingProductPic == null) {
                response.setStatus(404);
                response.setMsg("Fail to delete file. File not found");
                return response;
            }
            ratingProductPicRepository.delete(ratingProductPic);
        }

        if (file.exists()) {
            if(file.delete()) {
                response.setStatus(200);
                response.setMsg("Delete Successful");
                return response;
            }
            else {
                response.setStatus(404);
                response.setMsg("Fail to delete file");
                return response;
            }
        }
        else {
            response.setStatus(404);
            response.setMsg("Fail to delete file");
            return response;
        }
    }
}