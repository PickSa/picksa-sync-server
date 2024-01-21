package com.picksa.picksasync.originalApplication;

import com.picksa.picksasync.originalApplication.service.OriginalApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/applications/original")
public class OriginalApplicationController {

    private final OriginalApplicationService originalApplicationService;

    @PostMapping
    public ResponseEntity<Void> convertOriginalToApplication() {
        originalApplicationService.copyOriginalAsApplication();
        return ResponseEntity.ok().build();
    }

}
