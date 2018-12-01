package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.create.TrackingRestRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.create.TrackingCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.create.TrackingRestResponseParam;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.read.TrackingReadResponseParam;
import com.th.ac.ku.kps.cpe.ecommerce.unity.Common;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.logging.Logger;

public class TrackingServiceImpl implements TrackingService {
    private static final Logger LOGGER = Logger.getLogger(TrackingServiceImpl.class.getName());

    private HttpClient httpClient = HttpClientBuilder.create().build();

    private TrackingRestResponseParam HttpPost(TrackingRestRequest restRequest) {
        TrackingRestResponseParam responseParam;
        try {
            ObjectMapper obj = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
            responseParam = obj.readValue(json_string,TrackingRestResponseParam.class);
            LOGGER.info("RESPONSE : " + json_string);
            Common.LoggerInfo("RESPONSE responseParam :" , responseParam);
            return responseParam;
        }catch (Exception ex) {
           ex.getStackTrace();

        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        responseParam = new TrackingRestResponseParam();
        return responseParam;
    }
    private TrackingReadResponseParam HttpGet(String slug, String tracking_number){
        TrackingReadResponseParam responseParam;
        try {
            ObjectMapper obj = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            HttpGet request = new HttpGet("https://api.aftership.com/v4/trackings/"+slug+"/"+tracking_number);
            Common.LoggerInfo("HttpGet : Connected");
            request.addHeader("content-type", "application/json");
            request.addHeader("aftership-api-key", "4e377d7d-932c-4019-8a5b-07833b975c1e");
            HttpResponse response = httpClient.execute(request);
            String json_string = EntityUtils.toString(response.getEntity());
            responseParam = obj.readValue(json_string, TrackingReadResponseParam.class);
            Common.LoggerInfo("RESPONSE responseParam : ", responseParam);
            return responseParam;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            httpClient.getConnectionManager().shutdown();;
        }
        responseParam = new TrackingReadResponseParam();
        return responseParam;
    }

    public TrackingCreateResponse trackingPostResponse(TrackingRestRequest restRequest) {
        TrackingCreateResponse response = new TrackingCreateResponse();
        try {
            TrackingRestResponseParam responseParam = HttpPost(restRequest);
            response.setStatus(responseParam.getMeta().getCode());
            response.setMsg(responseParam.getMeta().getMessage());
        } catch (Exception e) {
            response.setStatus(400);
            response.setMsg("Error add tracking. Exception : " + e.toString());
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public TrackingReadResponseParam trackingReadAllResponse(String slug, String tracking_number) {
        return HttpGet(slug, tracking_number);
    }

}
