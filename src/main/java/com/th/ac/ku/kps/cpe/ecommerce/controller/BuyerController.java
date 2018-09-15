package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.unity.Common;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.BuyerRestRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.BuyerRestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class BuyerController implements Serializable {

    private static final long serialVersionUID = 1760405622859604123L;

    @PostMapping("/buyer")
    public BuyerRestResponse trackingRestRequest(@RequestBody BuyerRestRequest restRequest) {
        Common.LoggerInfo(restRequest);
        return null;
    }
}