package com.picksa.picksasync.originalApplication.converter;

import com.picksa.picksasync.originalApplication.domain.Part;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ApplicationConverterProvider {

    private final Map<Part, ApplicationCoverter> converters;

    public ApplicationConverterProvider(Set<ApplicationCoverter> converters) {
        this.converters = converters.stream()
                .collect(Collectors.toUnmodifiableMap(ApplicationCoverter::part, Function.identity()));
    }

    public ApplicationCoverter provideConverter(Part part) {
        return converters.get(part);
    }

}
