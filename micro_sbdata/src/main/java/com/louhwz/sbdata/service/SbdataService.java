package com.louhwz.sbdata.service;

import com.louhwz.sbdata.utils.Case;
import com.louhwz.sbdata.utils.HotelData;
import com.louhwz.sbdata.utils.Response;

import java.util.List;
import java.util.Map;

/**
 * @author Louhwz
 */
public interface SbdataService {
    Response getData(Integer caseId);

    List<HotelData> getHotelInfo(Integer expId);

    List<Case> getCaseInfo();

    boolean isReady(String groupId);
}
