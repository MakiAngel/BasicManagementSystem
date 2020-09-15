package com.uestc.fff.information.service;

import com.uestc.fff.information.domain.StudentInfo;
import com.uestc.fff.information.domain.StudentInfoExample;
import com.uestc.fff.information.mapper.StudentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentManageService {
    @Autowired
    StudentInfoMapper studentInfoMapper;

    public List<StudentInfo> findStusBySc(String scid) {
        StudentInfoExample studentInfoExample = new StudentInfoExample();
        studentInfoExample.createCriteria().andScIdEqualTo(scid);
        return studentInfoMapper.selectByExample(studentInfoExample);
    }

    public List<StudentInfo> studentInfoList() { return  studentInfoMapper.selectByExample(new StudentInfoExample()); }

    public void deleteStudentByID(String id) {
        studentInfoMapper.deleteByPrimaryKey(id);
    }

    public StudentInfo findStudentBySid(String sid){
        return studentInfoMapper.selectByPrimaryKey(sid);
    }

    public List<StudentInfo> searchStudent(String sname){
        StudentInfoExample studentInfoExample = new StudentInfoExample();
        studentInfoExample.createCriteria().andSnameLike("%" + sname + "%");
        return studentInfoMapper.selectByExample(studentInfoExample);
    }

    public void updateStudent(StudentInfo studentInfo) {
        studentInfoMapper.updateByPrimaryKey(studentInfo);
    }
}
