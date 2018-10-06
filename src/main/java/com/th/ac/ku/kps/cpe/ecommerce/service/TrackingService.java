package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.TrackingRestRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.TrackingRestResponse;
import org.springframework.stereotype.Service;

@Service
public interface TrackingService {
     TrackingRestResponse trackingResponse(TrackingRestRequest restRequest);
}
