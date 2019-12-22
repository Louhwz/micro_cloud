package com.louhwz.sbdata.repository.master;

import com.louhwz.sbdata.utils.Case;
import com.louhwz.sbdata.utils.HotelData;
import com.louhwz.sbdata.utils.I_Groups;
import com.louhwz.sbdata.utils.Sbdata;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SbdataDao {
    Sbdata getDataById(Integer id);

    List<HotelData> getHotelInfo(Integer groupId);

    List<Case> getCaseInfo();

    List<I_Groups> getValidCase(Integer iExpId);
}
