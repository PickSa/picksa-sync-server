package com.picksa.picksasync.application.controller;

import com.picksa.picksasync.application.dto.response.ApplicationSyncResponse;
import com.picksa.picksasync.application.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/sync")
    public ResponseEntity<ApplicationSyncResponse> getApplication(@RequestParam(required = false) LocalDateTime after) {
        if (after == null) {
            ApplicationSyncResponse response = applicationService.getAllApplications();
            return ResponseEntity.ok(response);
        }

        ApplicationSyncResponse response = applicationService.getApplicationsAfter(after);
        return ResponseEntity.ok(response);
    }

}
