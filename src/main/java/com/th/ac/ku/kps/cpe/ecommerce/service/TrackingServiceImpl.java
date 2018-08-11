package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.TrackingRestRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.TrackingRestResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.logging.Logger;

public class TrackingServiceImpl implements TrackingService {
    private static final Logger LOGGER = Logger.getLogger(TrackingServiceImpl.class.getName());

    private HttpClient httpClient = HttpClientBuilder.create().build();

    private void HttpPost(TrackingRestRequest restRequest) {
        try {
            ObjectMapper obj = new ObjectMapper();
            String jsonString = obj.writeValueAsString(restRequest);
            HttpPost request = new HttpPost("https://api.aftership.com/v4/trackings");
            LOGGER.info("HttpPost : Connected ");
            StringEntity params = new StringEntity(jsonString);
            request.addHeader("content-type", "application/json");
            request.addHeader("aftership-api-key", "4e377d7d-932c-4019-8a5b-07833b975c1e");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            LOGGER.info("HttpResponse : " + response);
            String json_string = EntityUtils.toString(response.getEntity());
            LOGGER.info("RESPONSE : " + json_string);
        }catch (Exception ex) {
           ex.getStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public TrackingRestResponse trackingResponse(TrackingRestRequest restRequest) {
        HttpPost(restRequest);
        return null;
    }

}
