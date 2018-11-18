package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.TrackingRestRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.TrackingRestResponse;
import com.th.ac.ku.kps.cpe.ecommerce.service.TrackingServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin
@RestController
public class TrackingController {

    private static final Logger LOGGER = Logger.getLogger(TrackingController.class.getName());

    @RequestMapping(method = RequestMethod.POST, value = "/tracking")
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
