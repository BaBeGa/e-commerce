package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.TrackingRestRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.TrackingRestResponse;
import com.th.ac.ku.kps.cpe.ecommerce.service.TrackingServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TrackingController {

    private static final Logger LOGGER = Logger.getLogger(TrackingController.class.getName());

    @PostMapping("/sample")
    public TrackingRestResponse trackingRestRequest(@RequestBody TrackingRestRequest restRequest) {
        ObjectMapper obj = new ObjectMapper();
        try {
            String jsonString = obj.writeValueAsString(restRequest);
            LOGGER.info("REQUESTING : " + jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        TrackingServiceImpl tracking = new TrackingServiceImpl();
        tracking.trackingResponse(restRequest);

        return null;
    }
}
