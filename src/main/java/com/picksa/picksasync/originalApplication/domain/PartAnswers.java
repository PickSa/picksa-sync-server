package com.picksa.picksasync.originalApplication.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class PartAnswers {

    private String partAnswer1;
    private String partAnswer2;
    private String partAnswer3;
    private String portfolio;

}
