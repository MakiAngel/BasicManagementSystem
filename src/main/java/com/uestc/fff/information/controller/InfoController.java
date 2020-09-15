package com.uestc.fff.information.controller;

import com.uestc.fff.information.domain.StudentInfo;
import com.uestc.fff.information.domain.TeacherInfo;
import com.uestc.fff.information.domain.UserInfo;
import com.uestc.fff.information.service.OtherService;
import com.uestc.fff.information.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private UserService userService;
    @Autowired
    private OtherService otherService;

    @RequestMapping("/school")
    public String ScPages(@RequestParam("schoolID") String scid, Model model, HttpSession session) {
        boolean islogin = false;
        UserInfo test = (UserInfo) session.getAttribute("user");

        if (test == null) { islogin = false; }
        else {
            islogin = true;

            if (test.getSort().equals("S")){
                StudentInfo s = userService.findStuBySID(test.getStid());
                model.addAttribute("User_name", s.getSname());
            }
            if (test.getSort().equals("T")){
                TeacherInfo t = userService.findTeaByTID(test.getStid());
                model.addAttribute("User_name", t.getTname());
            }
        }
        model.addAttribute("isLogin",islogin);
        model.addAttribute("Schools",otherService.schoolInfo(scid));
        model.addAttribute("Majors", otherService.majorInfoList(scid));
        model.addAttribute("Class", otherService.classInfoList(scid));
        model.addAttribute("Teachers", otherService.teacherInfoList(scid));

        return "ScInfo";
    }

    @RequestMapping("/mande")
    public String ClassPages(@RequestParam("cid") String cid, Model model, HttpSession session){
        boolean islogin = false;
        boolean isTeacher = false;
        UserInfo test = (UserInfo) session.getAttribute("user");

        if (test == null) { islogin = false; }
        else {
            islogin = true;

            if (test.getSort().equals("S")){
                StudentInfo s = userService.findStuBySID(test.getStid());
                model.addAttribute("User_name", s.getSname());
            }
            if (test.getSort().equals("T")){
                TeacherInfo t = userService.findTeaByTID(test.getStid());
                isTeacher = true;
                model.addAttribute("User_name", t.getTname());
                model.addAttribute("isTeacher", isTeacher);
            }
        }
        model.addAttribute("isLogin",islogin);

        model.addAttribute("Exercise", otherService.exerciseInfoList(cid));
        model.addAttribute("Materias", otherService.materiasInfoList(cid));
        model.addAttribute("Class", otherService.classInfo(cid));

        return "Class";
    }

    @RequestMapping("/answer")
    public  String AnswerPages(@RequestParam("eid") String eid, Model model, HttpSession session){
        boolean islogin = false;
        UserInfo test = (UserInfo) session.getAttribute("user");

        if (test == null) { islogin = false; }
        else {
            islogin = true;

            if (test.getSort().equals("S")){
                StudentInfo s = userService.findStuBySID(test.getStid());
                model.addAttribute("User_name", s.getSname());
            }
            if (test.getSort().equals("T")){
                TeacherInfo t = userService.findTeaByTID(test.getStid());
                model.addAttribute("User_name", t.getTname());
            }
        }
        model.addAttribute("isLogin",islogin);
        model.addAttribute("Answer", otherService.exerciseInfo(eid));

        return "Answer";
    }
}
