package com.picksa.picksasync.originalApplication.service;

import com.picksa.picksasync.application.Application;
import com.picksa.picksasync.application.repository.ApplicationRepository;
import com.picksa.picksasync.global.Generation;
import com.picksa.picksasync.originalApplication.InterviewAvailableConverter;
import com.picksa.picksasync.originalApplication.InterviewSchedule;
import com.picksa.picksasync.originalApplication.converter.ApplicationConverterProvider;
import com.picksa.picksasync.originalApplication.converter.ApplicationCoverter;
import com.picksa.picksasync.originalApplication.domain.OriginalApplication;
import com.picksa.picksasync.originalApplication.repository.InterviewScheduleRepository;
import com.picksa.picksasync.originalApplication.repository.OriginalApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OriginalApplicationService {

    private final OriginalApplicationRepository originalApplicationRepository;
    private final InterviewScheduleRepository interviewScheduleRepository;
    private final ApplicationRepository applicationRepository;

    private final ApplicationConverterProvider applicationConverterProvider;
    private final InterviewAvailableConverter interviewAvailableConverter;

    @Transactional
    public void copyOriginalAsApplication() {

        Application lastApplication = applicationRepository.findTopByOrderByOriginalIdDesc();
        Long lastOriginalId = 0L;
        if (lastApplication != null) {
            lastOriginalId = lastApplication.getOriginalId();
        }

        int generation = Generation.getGenerationOfThisYear();
        List<InterviewSchedule> interviewSchedules = interviewScheduleRepository.findByGenerationOrderByDate(generation);

        List<OriginalApplication> originals = originalApplicationRepository.findByIdAfter(lastOriginalId);

        List<Application> applicationsToSave = new ArrayList<>();
        for(OriginalApplication original: originals) {
            ApplicationCoverter applicationCoverter = applicationConverterProvider.provideConverter(original.getPart());
            String formattedInterviewAvailable = interviewAvailableConverter.formatTotalToBinary(original.getInterviewAvailable(), interviewSchedules);
            System.out.println("formattedInterviewAvailable = " + formattedInterviewAvailable);
            Application application = applicationCoverter.convertOriginalToApplication(original, formattedInterviewAvailable, original.getId(), generation);

            applicationsToSave.add(application);
        }

        applicationRepository.saveAll(applicationsToSave);
    }

}
