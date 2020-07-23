package com.uestc.fff.information.service;


import com.uestc.fff.information.domain.SchoolInfo;
import com.uestc.fff.information.domain.SchoolInfoExample;
import com.uestc.fff.information.mapper.SchoolInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class HostService {
    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    public List<SchoolInfo> schoolInfos() { return schoolInfoMapper.selectByExample(new SchoolInfoExample()); }

}