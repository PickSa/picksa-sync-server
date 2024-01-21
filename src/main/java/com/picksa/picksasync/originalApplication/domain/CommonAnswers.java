package com.picksa.picksasync.originalApplication.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class CommonAnswers {

    private String commonAnswer1;

    private String commonAnswer2;

    private String commonAnswer3;

    private String commonAnswer4;

    private String commonAnswer5;

}
