package com.louhwz.sbdata.service;

import com.louhwz.sbdata.repository.master.SbdataDao;
import com.louhwz.sbdata.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<HotelData> getHotelInfo(Integer expId) {
        List<I_Groups> groupsList = sbdataDao.getValidCase(expId);
        List<HotelData> hotelData = null;
        boolean isValid = true;
        if(groupsList.size() == 0)
            isValid = false;
        else{
            for(int i=0;i<groupsList.size();i++){
                if(groupsList.get(i).getCommitted()==0) {
                    isValid = false;
                    break;
                }
            }
        }
        if(!isValid){
            return null;
        }
        else
            hotelData = sbdataDao.getHotelInfo(groupsList.get(0).getGroupId());
        return hotelData;
    }

    public List<HotelData> getSpecificHotel(Integer groupId){
        return sbdataDao.getHotelInfo(groupId);
    }

    @Override
    public List<Case> getCaseInfo() {
        return sbdataDao.getCaseInfo();
    }

    @Override
    public boolean isReady(String groupId) {

        return true;

        /*sbdataDao.getReadyInfo();*/
    }
}
