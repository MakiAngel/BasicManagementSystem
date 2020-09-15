package com.uestc.fff.information.service;

import com.uestc.fff.information.domain.SchoolInfo;
import com.uestc.fff.information.domain.SchoolInfoExample;
import com.uestc.fff.information.mapper.SchoolInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScManageService {
    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    public List<SchoolInfo> listSchool(){
        return schoolInfoMapper.selectByExample(new SchoolInfoExample());
    }

    public void deleteSchoolByID(String id) {
        schoolInfoMapper.deleteByPrimaryKey(id);
    }

    public SchoolInfo findScByScid(String scid){
        return schoolInfoMapper.selectByPrimaryKey(scid);
    }

    public List<SchoolInfo> searchSchool(String scName){
        SchoolInfoExample schoolInfoExample = new SchoolInfoExample();
        schoolInfoExample.createCriteria().andScNameLike("%" + scName + "%");
        return schoolInfoMapper.selectByExample(schoolInfoExample);
    }

    public void updateSchool(SchoolInfo schoolInfo) {
        schoolInfoMapper.updateByPrimaryKey(schoolInfo);
    }

}
