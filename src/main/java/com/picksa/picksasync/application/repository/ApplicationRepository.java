package com.picksa.picksasync.application.repository;

import com.picksa.picksasync.application.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long>, ApplicationQueryRepository {

    Application findTopByOrderByOriginalIdDesc();

}
