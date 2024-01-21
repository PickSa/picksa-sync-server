package com.picksa.picksasync.application.repository;

import com.picksa.picksasync.application.dto.response.ApplicationDetailResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface ApplicationQueryRepository {

    List<ApplicationDetailResponse> getApplicationCreatedBetween(LocalDateTime after, LocalDateTime until);
    List<ApplicationDetailResponse> getApplicationsUntil(LocalDateTime until);

}
