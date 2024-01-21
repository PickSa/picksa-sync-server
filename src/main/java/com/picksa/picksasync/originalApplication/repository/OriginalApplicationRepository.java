package com.picksa.picksasync.originalApplication.repository;

import com.picksa.picksasync.originalApplication.domain.OriginalApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OriginalApplicationRepository extends JpaRepository<OriginalApplication, Long> {

    List<OriginalApplication> findByIdAfter(Long id);

}
