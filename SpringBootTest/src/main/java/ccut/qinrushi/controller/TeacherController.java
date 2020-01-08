package ccut.qinrushi.controller;

import ccut.qinrushi.service.TeacherService;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    ShowData showData;

    public String addTeacher(@RequestParam("teacher_id") String teacher_id,
                             @RequestParam("teacher_name") String teacher_name,
                             @RequestParam("sex") String sex,
                             @RequestParam("teacher_college") String teacher_college,
                             @RequestParam("teacher_major") String teacher_major){
        if("".equals(teacher_id)||teacher_id==null||"".equals(teacher_name)||teacher_name==null||"".equals(sex)||sex==null||
                "".equals(teacher_college)||teacher_college==null||"".equals(teacher_major)||teacher_major==null){
            return showData.showData(false,"请补全信息");
        }
        return teacherService.addTeacher(teacher_id, teacher_name, sex, teacher_college, teacher_major);
    }
}
