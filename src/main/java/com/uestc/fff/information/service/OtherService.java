package com.uestc.fff.information.service;

import com.uestc.fff.information.domain.*;
import com.uestc.fff.information.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OtherService {
    @Autowired
    private SchoolInfoMapper schoolInfoMapper;
    @Autowired
    private MajorListMapper majorListMapper;
    @Autowired
    private ClassListMapper classListMapper;
    @Autowired
    private ExeListMapper exeListMapper;
    @Autowired
    private MateriasListMapper materiasListMapper;
    @Autowired
    private  ExerciseInfoMapper exerciseInfoMapper;
    @Autowired
    private ClassInfoMapper classInfoMapper;
    @Autowired
    private TeacherListMapper teacherListMapper;

    public SchoolInfo schoolInfo(String scid) { return schoolInfoMapper.selectByPrimaryKey(scid); }

    public List<MajorInfo> majorInfoList(String scid) { return majorListMapper.selectBySchool(scid); }

    public List<ClassInfo> classInfoList(String scid) { return  classListMapper.selectBySchool(scid); }

    public List<ExerciseInfo> exerciseInfoList(String cid) { return  exeListMapper.selectByClass(cid); }

    public List<MateriasInfo> materiasInfoList(String cid) { return  materiasListMapper.selectByClass(cid); }

    public ExerciseInfo exerciseInfo(String eid) { return exerciseInfoMapper.selectByPrimaryKey(eid); }

    public ClassInfo classInfo(String cid) { return  classInfoMapper.selectByPrimaryKey(cid); }

    public List<TeacherInfo> teacherInfoList(String scid) { return teacherListMapper.selectBySchool(scid); }

}
