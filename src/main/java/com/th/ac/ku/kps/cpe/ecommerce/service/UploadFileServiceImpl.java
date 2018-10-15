package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.ProductPicEntity;
import com.th.ac.ku.kps.cpe.ecommerce.model.upload.UploadFileResponse;
import com.th.ac.ku.kps.cpe.ecommerce.repository.ProductPicRepository;
import com.th.ac.ku.kps.cpe.ecommerce.unity.Common;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class UploadFileServiceImpl implements UploadFileService {
    private final ProductPicRepository productPicRepository;

    public UploadFileServiceImpl(ProductPicRepository productPicRepository) {
        this.productPicRepository = productPicRepository;
    }

    @Override
    public UploadFileResponse uploadResponse(String token, Integer id_product, MultipartFile file, String UPLOAD_FOLDER) {
        UploadFileResponse response = new UploadFileResponse();
        ProductPicEntity productPicEntity = new ProductPicEntity();
        ProductEntity productEntity = new ProductEntity();

        String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        String filename = new Random().nextInt(999999) + "_" + System.currentTimeMillis();
        File targetFile = new File(UPLOAD_FOLDER + filename + fileExtension);
        try {
            file.transferTo(targetFile);
            Common.LoggerInfo(UPLOAD_FOLDER + filename + fileExtension);
            productPicEntity.setIdProduct(id_product);
            productPicEntity.setPicProduct(UPLOAD_FOLDER + filename + fileExtension);
            productPicRepository.save(productPicEntity);

            response.setStatus(200);
            response.setMsg("Upload successfully");

        } catch (IOException e) {
            response.setStatus(406);
            response.setMsg("Can't upload. Because have some exception\n Exception : " + e.toString());
        }
        return response;
    }


}
