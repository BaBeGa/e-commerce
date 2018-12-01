package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.create.TrackingRestRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.create.TrackingCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.tracking.read.TrackingReadResponseParam;
import org.springframework.stereotype.Service;

@Service
public interface TrackingService {
     TrackingCreateResponse trackingPostResponse(TrackingRestRequest restRequest);
     TrackingReadResponseParam trackingReadAllResponse(String slug, String tracking_number);
}
