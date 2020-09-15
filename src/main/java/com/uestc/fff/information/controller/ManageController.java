package com.uestc.fff.information.controller;

import com.uestc.fff.information.domain.*;
import com.uestc.fff.information.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    ScManageService scManageService;
    @Autowired
    MajorManageService majorManageService;
    @Autowired
    ClassManageService classManageService;
    @Autowired
    UserManageService userManageService;
    @Autowired
    StudentManageService studentManageService;
    @Autowired
    TeacherManageService teacherManageService;

    /***********************************/
    /**********SchoolManagement*********/
    /***********************************/
    @RequestMapping("/school")
    public String findSchool(Model model){
        model.addAttribute("Schools", scManageService.listSchool());
        return "ScManage";
    }

    @GetMapping("/deleteSchool")
    @ResponseBody
    public Boolean deleteSchool(@RequestParam("ScId") String scid){
        scManageService.deleteSchoolByID(scid);
        return true;
    }

    @PostMapping("/searchSchool")
    public String searchSchool(@RequestParam("scName") String scName,Model model){
        model.addAttribute("Schools",scManageService.searchSchool(scName));
        return "ScManage";
    }

    @GetMapping("/editSchool")
    public String editSchool(@RequestParam("scID") String scID, Model model) {
        SchoolInfo schoolInfo = scManageService.findScByScid(scID);
        model.addAttribute("school", schoolInfo);
        return "SchoolEdit";
    }

    @PostMapping("/editSchool")
    public String updateSchool(SchoolInfo schoolInfo) {
        scManageService.updateSchool(schoolInfo);
        return "redirect:/manage/school";
    }

    @GetMapping("/schooltoMajor")
    public String schoolToMajor(@RequestParam String scID, Model model) {
        model.addAttribute("Majors", majorManageService.findMajorBySc(scID));
        return "MajorManage";
    }

    @GetMapping("/schooltoClass")
    public String schoolToClass(@RequestParam String scID, Model model) {
        model.addAttribute("Class", classManageService.findClassBySc(scID));
        return "ClassManage";
    }

    @GetMapping("/schooltoStudent")
    public String schoolToStudent(@RequestParam String scID, Model model) {
        model.addAttribute("Students", studentManageService.findStusBySc(scID));
        return "StudentManage";
    }

    @GetMapping("/schooltoTeacher")
    public String schoolToTeacher(@RequestParam String scID, Model model) {
        model.addAttribute("Teachers", teacherManageService.findTeaBySc(scID));
        return "TeacherManage";
    }
    /**********************************/
    /**********MajorManagement*********/
    /**********************************/
    @RequestMapping("/major")
    public String findMajor(Model model){
        model.addAttribute("Majors", majorManageService.majorInfoList());
        return "MajorManage";
    }

    @GetMapping("/deleteMajor")
    @ResponseBody
    public Boolean deleteMajor(@RequestParam("mid") String mid){
        majorManageService.deleteMajorByID(mid);
        return true;
    }

    @PostMapping("/searchMajor")
    public String searchMajor(@RequestParam("mname") String mname,Model model){
        model.addAttribute("Majors",majorManageService.searchMajor(mname));
        return "MajorManage";
    }

    @GetMapping("/editMajor")
    public String editMajor(@RequestParam("mid") String mid, Model model) {
        MajorInfo majorInfo = majorManageService.findMajorByMid(mid);
        model.addAttribute("major", majorInfo);
        return "MajorEdit";
    }

    @PostMapping("/editMajor")
    public String updateMajor(MajorInfo majorInfo) {
        majorManageService.updateMajor(majorInfo);
        return "redirect:/manage/major";
    }
    /**********************************/
    /**********ClassManagement*********/
    /**********************************/
    @RequestMapping("/class")
    public String findClass(Model model){
        model.addAttribute("Class", classManageService.classInfoList());
        return "ClassManage";
    }

    @GetMapping("/deleteClass")
    @ResponseBody
    public Boolean deleteClass(@RequestParam("cid") String cid){
        classManageService.deleteClassByID(cid);
        return true;
    }

    @PostMapping("/searchClass")
    public String searchClass(@RequestParam("cname") String cname,Model model){
        model.addAttribute("Class", classManageService.searchClass(cname));
        return "ClassManage";
    }

    @GetMapping("/editClass")
    public String editClass(@RequestParam("cid") String cid, Model model) {
        ClassInfo classInfo = classManageService.findClassByCid(cid);
        model.addAttribute("class", classInfo);
        return "ClassEdit";
    }

    @PostMapping("/editClass")
    public String updateClass(ClassInfo classInfo) {
        classManageService.updateClass(classInfo);
        return "redirect:/manage/class";
    }
    /**********************************/
    /**********UserManagement**********/
    /**********************************/
    @RequestMapping("/user")
    public String findUser(Model model){
        model.addAttribute("UserManage", userManageService.userInfoList());
        return "UserManage";
    }

    @GetMapping("/deleteUser")
    @ResponseBody
    public Boolean deleteUser(@RequestParam("uid") String uid){
        userManageService.deleteUserByID(uid);
        return true;
    }

    @PostMapping("/searchUser")
    public String searchUser(@RequestParam("stid") String stid, Model model){
        model.addAttribute("UserManage", userManageService.searchUser(stid));
        return "UserManage";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam("uid") String uid, Model model) {
        UserInfo userInfo = userManageService.findUserByUid(uid);
        model.addAttribute("userEdit", userInfo);
        return "UserEdit";
    }

    @PostMapping("/editUser")
    public String updateUser(UserInfo userInfo) {
        userManageService.updateUser(userInfo);
        return "redirect:/manage/user";
    }
    /**********************************/
    /**********StudentManagement*******/
    /**********************************/
    @RequestMapping("/student")
    public String findStudent(Model model){
        model.addAttribute("Students", studentManageService.studentInfoList());
        return "StudentManage";
    }

    @GetMapping("/deleteStudent")
    @ResponseBody
    public Boolean deleteStudent(@RequestParam("sid") String sid){
        studentManageService.deleteStudentByID(sid);
        return true;
    }

    @PostMapping("/searchStudent")
    public String searchStudent(@RequestParam("sname") String sname, Model model){
        model.addAttribute("Students",studentManageService.searchStudent(sname));
        return "StudentManage";
    }

    @GetMapping("/editStudent")
    public String editStudent(@RequestParam("sid") String sid, Model model) {
        StudentInfo studentInfo = studentManageService.findStudentBySid(sid);
        model.addAttribute("student", studentInfo);
        return "StudentEdit";
    }

    @PostMapping("/editStudent")
    public String updateStudent(StudentInfo studentInfo) {
        studentManageService.updateStudent(studentInfo);
        return "redirect:/manage/student";
    }
    /**********************************/
    /**********TeacherManagement*******/
    /**********************************/
    @RequestMapping("/teacher")
    public String findTeacher(Model model){
        model.addAttribute("Teachers", teacherManageService.teacherInfoList());
        return "TeacherManage";
    }

    @GetMapping("/deleteTeacher")
    @ResponseBody
    public Boolean deleteTeacher(@RequestParam("tid") String tid){
        teacherManageService.deleteTeacherByID(tid);
        return true;
    }

    @PostMapping("/searchTeacher")
    public String searchTeacher(@RequestParam("tname") String tname,Model model){
        model.addAttribute("Teachers",teacherManageService.searchTeacher(tname));
        return "TeacherManage";
    }

    @GetMapping("/editTeacher")
    public String editTeacher(@RequestParam("tid") String tid, Model model) {
        TeacherInfo teacherInfo = teacherManageService.findTeacherByTid(tid);
        model.addAttribute("teacher", teacherInfo);
        return "TeacherEdit";
    }

    @PostMapping("/editTeacher")
    public String updateTeacher(TeacherInfo teacherInfo) {
        teacherManageService.updateTeacher(teacherInfo);
        return "redirect:/manage/teacher";
    }
}
