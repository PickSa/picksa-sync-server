package com.picksa.picksasync.application.repository;

import com.picksa.picksasync.application.dto.response.ApplicationDetailResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.picksa.picksasync.application.QApplication.application;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationQueryRepositoryImpl implements ApplicationQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ApplicationDetailResponse> getApplicationCreatedBetween(LocalDateTime after, LocalDateTime until) {
        return jpaQueryFactory.select(Projections.constructor(
                        ApplicationDetailResponse.class,
                        application.personalData.name,
                        application.personalData.studentId,
                        application.personalData.email,
                        application.personalData.gender,
                        application.personalData.major,
                        application.personalData.multiMajor,
                        application.personalData.phone,
                        application.personalData.semester,
                        application.partAnswers.portfolio,
                        application.part,
                        application.generation,
                        application.commonAnswers.commonAnswer1,
                        application.commonAnswers.commonAnswer2,
                        application.commonAnswers.commonAnswer3,
                        application.commonAnswers.commonAnswer4,
                        application.commonAnswers.commonAnswer5,
                        application.partAnswers.partAnswer1,
                        application.partAnswers.partAnswer2,
                        application.partAnswers.partAnswer3,
                        application.interviewAvailableTimes
                ))
                .from(application)
                .where(
                        application.createdAt.after(after)
                                .orAllOf(application.createdAt.before(until),
                                        application.createdAt.eq(until)
                                )
                )
                .orderBy(
                        application.createdAt.desc()
                )
                .fetch();
    }

    @Override
    public List<ApplicationDetailResponse> getApplicationsUntil(LocalDateTime until) {
        return jpaQueryFactory.select(Projections.constructor(
                        ApplicationDetailResponse.class,
                        application.personalData.name,
                        application.personalData.studentId,
                        application.personalData.email,
                        application.personalData.gender,
                        application.personalData.major,
                        application.personalData.multiMajor,
                        application.personalData.phone,
                        application.personalData.semester,
                        application.partAnswers.portfolio,
                        application.part,
                        application.generation,
                        application.commonAnswers.commonAnswer1,
                        application.commonAnswers.commonAnswer2,
                        application.commonAnswers.commonAnswer3,
                        application.commonAnswers.commonAnswer4,
                        application.commonAnswers.commonAnswer5,
                        application.partAnswers.partAnswer1,
                        application.partAnswers.partAnswer2,
                        application.partAnswers.partAnswer3,
                        application.interviewAvailableTimes
                ))
                .from(application)
                .where(
                        application.createdAt.before(until)
                                .or(application.createdAt.eq(until))
                )
                .orderBy(
                        application.createdAt.desc()
                )
                .fetch();
    }

}
