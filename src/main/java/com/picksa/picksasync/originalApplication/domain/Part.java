package com.picksa.picksasync.originalApplication.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Part {

    PM("기획"),
    DESIGN("디자인"),
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Part(String name) {
        this.name = name;
    }

    public static Part from(String name) {
        return Arrays.stream(Part.values())
                .filter(v -> v.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

}
