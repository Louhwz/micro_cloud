package com.louhwz.sbdata.service;

import com.louhwz.sbdata.utils.HotelData;
import com.louhwz.sbdata.utils.Response;

import java.util.List;

/**
 * @author Louhwz
 */
public interface SbdataService {
    Response getData(Integer caseId);

    List<HotelData> getHotelInfo(Integer groupId);
}
