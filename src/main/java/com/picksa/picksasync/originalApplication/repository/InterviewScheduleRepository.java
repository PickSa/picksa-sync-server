package com.picksa.picksasync.originalApplication.repository;

import com.picksa.picksasync.originalApplication.InterviewSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewScheduleRepository extends JpaRepository<InterviewSchedule, Long> {

    List<InterviewSchedule> findByGenerationOrderByDate(int Generation);

}
