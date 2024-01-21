package com.picksa.picksasync.application;

import com.picksa.picksasync.global.BaseTimeEntity;
import com.picksa.picksasync.originalApplication.domain.CommonAnswers;
import com.picksa.picksasync.originalApplication.domain.Part;
import com.picksa.picksasync.originalApplication.domain.PartAnswers;
import com.picksa.picksasync.originalApplication.domain.PersonalData;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Application extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean agreePrivacyCollection;

    @Enumerated(EnumType.STRING)
    private Part part;

    @Column
    private int generation;

    @Embedded
    private PersonalData personalData;

    @Embedded
    private CommonAnswers commonAnswers;

    @Embedded
    private PartAnswers partAnswers;

    @Column
    private String interviewAvailableTimes;

    @Column
    private Long originalId;

    @Builder
    public Application(boolean agreePrivacyCollection, Part part, int generation, PersonalData personalData, CommonAnswers commonAnswers, PartAnswers partAnswers, String interviewAvailableTimes, Long originalId) {
        this.agreePrivacyCollection = agreePrivacyCollection;
        this.part = part;
        this.personalData = personalData;
        this.commonAnswers = commonAnswers;
        this.partAnswers = partAnswers;
        this.interviewAvailableTimes = interviewAvailableTimes;
        this.generation = generation;
        this.originalId = originalId;
    }

}

