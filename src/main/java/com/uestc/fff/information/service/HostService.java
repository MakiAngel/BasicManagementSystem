package com.uestc.fff.information.service;


import com.uestc.fff.information.domain.SchoolInfo;
import com.uestc.fff.information.domain.SchoolInfoExample;
import com.uestc.fff.information.mapper.SchoolInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HostService {
    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    public List<SchoolInfo> fullSearch(String scName) {
        SchoolInfoExample schoolInfoExample = new SchoolInfoExample();
        SchoolInfoExample.Criteria criteria = schoolInfoExample.createCriteria();
        criteria.andScNameLike("%"+scName+"%");


        List<SchoolInfo> searchResultList = schoolInfoMapper.selectByExample(schoolInfoExample);

        if (!searchResultList.isEmpty()) {
            return searchResultList;
        }
        else{
            return null;
        }
    }

}