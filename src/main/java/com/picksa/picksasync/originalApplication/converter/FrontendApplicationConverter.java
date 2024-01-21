package com.picksa.picksasync.originalApplication.converter;

import com.picksa.picksasync.application.Application;
import com.picksa.picksasync.originalApplication.domain.OriginalApplication;
import com.picksa.picksasync.originalApplication.domain.Part;
import org.springframework.stereotype.Component;

@Component
public class FrontendApplicationConverter implements ApplicationCoverter {
    @Override
    public Part part() {
        return Part.FRONTEND;
    }

    @Override
    public Application convertOriginalToApplication(OriginalApplication original, String interviewAvailables, Long originalId, int generation) {

        // TODO: 2024-01-20 기수 자동 적용
        return Application.builder()
                .agreePrivacyCollection(original.isAgreePrivacyCollection())
                .part(original.getPart())
                .generation(generation)
                .personalData(original.getPersonalData())
                .commonAnswers(original.getCommonAnswer())
                .partAnswers(original.getFrontend())
                .interviewAvailableTimes(interviewAvailables)
                .originalId(originalId)
                .build();
    }
}
