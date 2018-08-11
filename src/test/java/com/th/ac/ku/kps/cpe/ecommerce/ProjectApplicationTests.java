package com.th.ac.ku.kps.cpe.ecommerce;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.TrackingRestRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.TrackingRestRequestBody;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {

    private static final Logger LOGGER = Logger.getLogger(ProjectApplicationTests.class.getName());
    @Test
    public void contextLoads() {
        TrackingRestRequest tracking = new TrackingRestRequest();
        TrackingRestRequestBody body = new TrackingRestRequestBody();
        body.setSlug("thailand-post");
        body.setTracking_number("EV123456789TH");
        tracking.setTracking(body);
        ObjectMapper obj = new ObjectMapper();
        try {
            String jsonString = obj.writeValueAsString(tracking);
            LOGGER.info("REQUEST : " + jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
