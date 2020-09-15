package com.uestc.fff.information.service;

import com.uestc.fff.information.domain.ClassInfo;
import com.uestc.fff.information.domain.ClassInfoExample;
import com.uestc.fff.information.mapper.ClassInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassManageService {
    @Autowired
    ClassInfoMapper classInfoMapper;

    public List<ClassInfo> findClassBySc(String scid) {
        ClassInfoExample classInfoExample = new ClassInfoExample();
        classInfoExample.createCriteria().andScIdEqualTo(scid);
        return classInfoMapper.selectByExample(classInfoExample);
    }

    public List<ClassInfo> classInfoList() { return  classInfoMapper.selectByExample(new ClassInfoExample()); }

    public void deleteClassByID(String id) {
        classInfoMapper.deleteByPrimaryKey(id);
    }

    public ClassInfo findClassByCid(String cid){
        return classInfoMapper.selectByPrimaryKey(cid);
    }

    public List<ClassInfo> searchClass(String cname){
        ClassInfoExample classInfoExample = new ClassInfoExample();
        classInfoExample.createCriteria().andCnameLike("%" + cname + "%");
        return classInfoMapper.selectByExample(classInfoExample);
    }

    public void updateClass(ClassInfo classInfo) {
        classInfoMapper.updateByPrimaryKey(classInfo);
    }
}
