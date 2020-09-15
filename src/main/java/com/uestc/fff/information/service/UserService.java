package com.uestc.fff.information.service;

import com.uestc.fff.information.domain.*;
import com.uestc.fff.information.mapper.SchoolInfoMapper;
import com.uestc.fff.information.mapper.StudentInfoMapper;
import com.uestc.fff.information.mapper.TeacherInfoMapper;
import com.uestc.fff.information.mapper.UserInfoMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    public StudentInfo findStuBySID(String sid)
    {
        return studentInfoMapper.selectByPrimaryKey(sid);
    }

    public void updateStuInfo(StudentInfo sinfo)
    {
        studentInfoMapper.updateByPrimaryKey(sinfo);
    }

    public TeacherInfo findTeaByTID(String tid)
    {
        return teacherInfoMapper.selectByPrimaryKey(tid);
    }

    public void updateTeaInfo(TeacherInfo tinfo)
    {
        teacherInfoMapper.updateByPrimaryKey(tinfo);
    }

    public UserInfo findByID(String id) { return  userInfoMapper.selectBySTid(id); }

    public SchoolInfo findScByScid(String scid) { return schoolInfoMapper.selectByPrimaryKey(scid); }

    public void updateUserInfo(UserInfo uinfo)
    {
        userInfoMapper.updateByPrimaryKey(uinfo);
    }
}