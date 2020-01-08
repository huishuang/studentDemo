package ccut.qinrushi.service;

import ccut.qinrushi.dao.TeacherDao;
import ccut.qinrushi.entity.Teacher;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    ShowData showData;

    public String addTeacher(String teacher_id, String teacher_name, String sex, String teacher_college, String teacher_major){
        Teacher teacher = new Teacher(teacher_id, teacher_name, sex, teacher_college, teacher_major);
        Teacher save = teacherDao.save(teacher);
        return showData.showData(true,"新老师添加成功！");
    }
}
