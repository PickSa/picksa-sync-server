package com.picksa.picksasync.originalApplication;

import com.picksa.picksasync.originalApplication.domain.InterviewAvailable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Component
public class InterviewAvailableConverter {

    private static final String BLANK = "";
    private static final long TIME_UNIT = 30;
    private static final char AVAILABLE = '1';

    public String formatTotalToBinary(InterviewAvailable interviewAvailable, List<InterviewSchedule> interviewSchedules) {

        String day1 = interviewAvailable.getDay1();
        String formattedDay1 = formatDayToBinary(day1, interviewSchedules.get(0));

        String day2 = interviewAvailable.getDay1();
        String formattedDay2 = formatDayToBinary(day2, interviewSchedules.get(1));

        String day3 = interviewAvailable.getDay1();
        String formattedDay3 = formatDayToBinary(day3, interviewSchedules.get(2));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formattedDay1);
        stringBuilder.append(formattedDay2);
        stringBuilder.append(formattedDay3);

        return stringBuilder.toString();
    }


    private String formatDayToBinary(String original, InterviewSchedule schedule) {
        if (!StringUtils.hasText(original)) {
            return BLANK;
        }

        String fomattedOfDay = getBaseFormat(schedule);

        String[] choices = splitChoiceOriginal(original);

        for(String choice:choices) {
            LocalTime startOfTime = getStartOfTime(choice);
            int indexOfTime = getIndexOfTime(schedule.getStartAt(), startOfTime);
            fomattedOfDay = setTimeAvailable(fomattedOfDay, indexOfTime);
        }

        return fomattedOfDay;
    }

    private String getBaseFormat(InterviewSchedule schedule) {
        Duration duration = Duration.between(schedule.getStartAt(), schedule.getFinishAt());
        System.out.println("duration.toMinutes() = " + duration.toMinutes());
        long length = duration.toMinutes() / TIME_UNIT;
        System.out.println(length);
        String baseFormat = "0".repeat((int) length);

        return baseFormat;
    }

    private String[] splitChoiceOriginal(String choice) {
        String blankRemoved = choice.replaceAll(" ", BLANK);
        String[] splitted = blankRemoved.split(",");

        return splitted;
    }

    private LocalTime getStartOfTime(String choice) {
        String[] times = choice.split("-");
        String[] timeElements = times[0].split(":");
        int hour = Integer.parseInt(timeElements[0]);
        int minute = Integer.parseInt(timeElements[1]);

        return LocalTime.of(hour, minute);
    }

    private int getIndexOfTime(LocalTime startOfDay, LocalTime time) {
        Duration duration = Duration.between(startOfDay, time);
        System.out.println("duration = " + duration.toMinutes());
        long index = duration.toMinutes() / TIME_UNIT;
        System.out.println("index = " + index);
        return (int) index;
    }

    private String setTimeAvailable(String formattedString, int index) {
        StringBuilder stringBuilder = new StringBuilder(formattedString);
        stringBuilder.setCharAt(index, AVAILABLE);

        return stringBuilder.toString();
    }

}

