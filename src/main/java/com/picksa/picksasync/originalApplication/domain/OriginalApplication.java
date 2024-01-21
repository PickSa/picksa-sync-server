package com.picksa.picksasync.originalApplication.domain;

import com.picksa.picksasync.originalApplication.repository.AgreementConverter;
import com.picksa.picksasync.originalApplication.repository.PartConverter;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OriginalApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String timestamp;

    @Column
    @Convert(converter = AgreementConverter.class)
    private boolean agreePrivacyCollection;

    @Column
    private String pathToKnow;

    @Enumerated(EnumType.STRING)
    @Convert(converter = PartConverter.class)
    private Part part;

    @Embedded
    private PersonalData personalData;

    @Embedded
    private CommonAnswers commonAnswer;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "partAnswer1", column = @Column(name = "pm_answer1")),
            @AttributeOverride(name = "partAnswer2", column = @Column(name = "pm_answer2")),
            @AttributeOverride(name = "partAnswer3", column = @Column(name = "pm_answer3")),
            @AttributeOverride(name = "portfolio", column = @Column(name = "pm_portfolio"))
    })
    private PartAnswers pm;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "partAnswer1", column = @Column(name = "design_answer1")),
            @AttributeOverride(name = "partAnswer2", column = @Column(name = "design_answer2")),
            @AttributeOverride(name = "partAnswer3", column = @Column(name = "design_answer3")),
            @AttributeOverride(name = "portfolio", column = @Column(name = "design_portfolio"))
    })
    private PartAnswers design;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "partAnswer1", column = @Column(name = "frontend_answer1")),
            @AttributeOverride(name = "partAnswer2", column = @Column(name = "frontend_answer2")),
            @AttributeOverride(name = "partAnswer3", column = @Column(name = "frontend_answer3")),
            @AttributeOverride(name = "portfolio", column = @Column(name = "frontend_portfolio"))
    })
    private PartAnswers frontend;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "partAnswer1", column = @Column(name = "backend_answer1")),
            @AttributeOverride(name = "partAnswer2", column = @Column(name = "backend_answer2")),
            @AttributeOverride(name = "partAnswer3", column = @Column(name = "backend_answer3")),
            @AttributeOverride(name = "portfolio", column = @Column(name = "backend_portfolio"))
    })
    private PartAnswers backend;

    @Embedded
    private InterviewAvailable interviewAvailable;

}
