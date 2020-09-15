package com.uestc.fff.information.service;

import com.uestc.fff.information.domain.TeacherInfo;
import com.uestc.fff.information.domain.TeacherInfoExample;
import com.uestc.fff.information.mapper.TeacherInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherManageService {
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;

    public List<TeacherInfo> findTeaBySc(String scid) {
        TeacherInfoExample teacherInfoExample = new TeacherInfoExample();
        teacherInfoExample.createCriteria().andScIdEqualTo(scid);
        return teacherInfoMapper.selectByExample(teacherInfoExample);
    }

    public List<TeacherInfo> teacherInfoList() { return  teacherInfoMapper.selectByExample(new TeacherInfoExample()); }

    public void deleteTeacherByID(String id) {
        teacherInfoMapper.deleteByPrimaryKey(id);
    }

    public TeacherInfo findTeacherByTid(String tid){
        return teacherInfoMapper.selectByPrimaryKey(tid);
    }

    public List<TeacherInfo> searchTeacher(String tname){
        TeacherInfoExample teacherInfoExample = new TeacherInfoExample();
        teacherInfoExample.createCriteria().andTnameLike("%" + tname + "%");
        return teacherInfoMapper.selectByExample(teacherInfoExample);
    }

    public void updateTeacher(TeacherInfo teacherInfo) {
        teacherInfoMapper.updateByPrimaryKey(teacherInfo);
    }
}
