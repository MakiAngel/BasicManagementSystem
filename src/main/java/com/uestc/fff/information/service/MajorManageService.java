package com.uestc.fff.information.service;

import com.uestc.fff.information.domain.MajorInfo;
import com.uestc.fff.information.domain.MajorInfoExample;
import com.uestc.fff.information.mapper.MajorInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorManageService {
    @Autowired
    private MajorInfoMapper majorInfoMapper;

    public List<MajorInfo> findMajorBySc(String scid) {
        MajorInfoExample majorInfoExample = new MajorInfoExample();
        majorInfoExample.createCriteria().andScIdEqualTo(scid);
        return majorInfoMapper.selectByExample(majorInfoExample);
    }

    public List<MajorInfo> majorInfoList() { return  majorInfoMapper.selectByExample(new MajorInfoExample()); }

    public void deleteMajorByID(String id) {
        majorInfoMapper.deleteByPrimaryKey(id);
    }

    public MajorInfo findMajorByMid(String mid){
        return majorInfoMapper.selectByPrimaryKey(mid);
    }

    public List<MajorInfo> searchMajor(String mname){
        MajorInfoExample majorInfoExample = new MajorInfoExample();
        majorInfoExample.createCriteria().andMnameLike("%" + mname + "%");
        return majorInfoMapper.selectByExample(majorInfoExample);
    }

    public void updateMajor(MajorInfo majorInfo) {
        majorInfoMapper.updateByPrimaryKey(majorInfo);
    }

}
