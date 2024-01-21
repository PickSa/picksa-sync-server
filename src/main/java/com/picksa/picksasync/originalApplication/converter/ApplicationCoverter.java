package com.picksa.picksasync.originalApplication.converter;

import com.picksa.picksasync.application.Application;
import com.picksa.picksasync.originalApplication.domain.OriginalApplication;
import com.picksa.picksasync.originalApplication.domain.Part;

public interface ApplicationCoverter {

    Part part();

    Application convertOriginalToApplication(OriginalApplication original, String interviewAvailables, Long originalId, int generation);

}
