package com.louhwz.sbdata.service;

import com.louhwz.sbdata.repository.SbdataDao;
import com.louhwz.sbdata.utils.Case;
import com.louhwz.sbdata.utils.HotelData;
import com.louhwz.sbdata.utils.Response;
import com.louhwz.sbdata.utils.Sbdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SbdataServiceImpl implements SbdataService{

    @Autowired
    SbdataDao sbdataDao;

    @Override
    public Response getData(Integer caseId) {

        Sbdata sbdata = sbdataDao.getDataById(caseId);
        return new Response(200,"查询成功",sbdata);
    }

    @Override
    public List<HotelData> getHotelInfo(Integer groupId) {
        List<HotelData> hotelData = sbdataDao.getHotelInfo(groupId);
        return hotelData;
    }

    @Override
    public List<Case> getCaseInfo() {
        return sbdataDao.getCaseInfo();
    }
}
