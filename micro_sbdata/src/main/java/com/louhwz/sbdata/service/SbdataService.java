package com.louhwz.sbdata.service;

import com.louhwz.sbdata.utils.Case;
import com.louhwz.sbdata.utils.HotelData;
import com.louhwz.sbdata.utils.I_Groups;
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

    /**
     * 针对前端接口的调用，返回特定groupid下的酒店订单数据供客户选择
     * @param groupId
     * @return
     */
    List<HotelData> getSpecificHotel(Integer groupId);

    List<I_Groups> getGroupsInCase(Integer expId);
}
