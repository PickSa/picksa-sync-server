package com.picksa.picksasync.originalApplication.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class InterviewAvailable {

    private String day1;
    private String day2;
    private String day3;

}
