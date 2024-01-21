package com.picksa.picksasync.originalApplication.converter;

import com.picksa.picksasync.application.Application;
import com.picksa.picksasync.originalApplication.domain.OriginalApplication;
import com.picksa.picksasync.originalApplication.domain.Part;
import org.springframework.stereotype.Component;

@Component
public class PmApplicationConverter implements ApplicationCoverter {

    @Override
    public Part part() {
        return Part.PM;
    }

    @Override
    public Application convertOriginalToApplication(OriginalApplication original, String interviewAvailables, Long originalId, int generation) {

        return Application.builder()
                .agreePrivacyCollection(original.isAgreePrivacyCollection())
                .part(original.getPart())
                .generation(generation)
                .personalData(original.getPersonalData())
                .commonAnswers(original.getCommonAnswer())
                .partAnswers(original.getPm())
                .interviewAvailableTimes(interviewAvailables)
                .originalId(originalId)
                .build();
    }
}
