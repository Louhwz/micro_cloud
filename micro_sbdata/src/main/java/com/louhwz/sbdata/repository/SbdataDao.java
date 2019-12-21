package com.louhwz.sbdata.repository;

import com.louhwz.sbdata.utils.Case;
import com.louhwz.sbdata.utils.HotelData;
import com.louhwz.sbdata.utils.Sbdata;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SbdataDao {
    Sbdata getDataById(Integer id);

    List<HotelData> getHotelInfo(Integer groupId);

    List<Case> getCaseInfo();

    Boolean getReadyInfo(Integer groupId);
}
