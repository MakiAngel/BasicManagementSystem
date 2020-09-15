package com.uestc.fff.information.service;

import com.uestc.fff.information.domain.MateriasInfo;
import com.uestc.fff.information.mapper.MateriasInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadService {
    @Autowired
    private MateriasInfoMapper materiasInfoMapper;

    public void SaveM(MateriasInfo materiasInfo) { materiasInfoMapper.insertSelective(materiasInfo); }
}
