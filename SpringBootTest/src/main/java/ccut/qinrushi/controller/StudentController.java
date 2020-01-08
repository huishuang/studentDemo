package ccut.qinrushi.controller;

import ccut.qinrushi.dao.StudentDao;
import ccut.qinrushi.service.StudentService;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentDao studentDao;
    @Autowired
    ShowData showData;

    //查询所有
    @GetMapping(path = "/findAllStudent")
    public String findAll() {
        return studentService.findAll();
    }

    //根据学院、专业、班级、学号查询
    @GetMapping(path="/findByStudentCollegeAndStudentMajorAndClassIdAndStudentId")
    public String findByStudentCollegeAndStudentMajorAndClassIdAndStudentId(@RequestParam("studentCollege") String studentCollege,
                                                                            @RequestParam("studentMajor") String studentMajor,
                                                                            @RequestParam("classId") String classId,
                                                                            @RequestParam("studentId") String studentId) {
        if ("".equals(studentCollege) || studentCollege == null || "".equals(studentMajor) || studentMajor == null
                || "".equals(classId) || classId == null || "".equals(studentId) || studentId == null) {
            return showData.showData(false, "请补全信息");
        }
        return studentService.findByStudentCollegeAndStudentMajorAndClassIdAndStudentId(studentCollege, studentMajor, classId,studentId);
    }

    //根据学院、专业、班级查询
    @GetMapping(path="/findByStudentCollegeAndStudentMajorAndClassId")
    public String findByStudentCollegeAndStudentMajorAndClassIdAndStudentId(@RequestParam("studentCollege") String studentCollege,
                                                                            @RequestParam("studentMajor") String studentMajor,
                                                                            @RequestParam("classId") String classId) {
        if ("".equals(studentCollege) || studentCollege == null || "".equals(studentMajor) || studentMajor == null
                || "".equals(classId) || classId == null) {
            return showData.showData(false, "请补全信息");
        }
        return studentService.findByStudentCollegeAndStudentMajorAndClassId(studentCollege, studentMajor, classId);
    }

    //根据学院、班级查询
    @GetMapping(path="/findByStudentCollegeAndClassId")
    public String findByStudentCollegeAndStudentMajorAndClassIdAndStudentId(@RequestParam("studentCollege") String studentCollege,
                                                                            @RequestParam("classId") String classId) {
        if ("".equals(studentCollege) || studentCollege == null|| "".equals(classId) || classId == null) {
            return showData.showData(false, "请补全信息");
        }
        return studentService.findByStudentCollegeAndClassId(studentCollege, classId);
    }


    //根据学院和专业查询多个
    @GetMapping(path="/findByStudentCollegeAndStudentMajor")
    public String findByStudentCollegeAndStudentMajor(@RequestParam("studentCollege") String studentCollege,
                                                      @RequestParam("studentMajor") String studentMajor) {
        if ("".equals(studentCollege) || studentCollege == null || "".equals(studentMajor) || studentMajor == null) {
            return showData.showData(false, "请补全信息");
        }
        return studentService.findByStudentCollegeAndStudentMajor(studentCollege, studentMajor);
    }

    //根据学生学院查询多条数据
    @GetMapping(value = "/findByStudentCollege")
    public String findByStudentCollege(@RequestParam("studentCollege") String studentCollege) {
        if ("".equals(studentCollege) || studentCollege == null) {
            return showData.showData(false, "学院不能为空");
        }
        return studentService.findByStudentCollege(studentCollege);
    }

    //根据学生专业查询多条数据
    @GetMapping(value = "/findByStudentMajor")
    public String findByStudentMajor(@RequestParam("studentMajor") String studentMajor) {
        if ("".equals(studentMajor) || studentMajor == null) {
            return showData.showData(false, "专业不能为空");
        }
        return studentService.findByStudentMajor(studentMajor);
    }

    //根据学生班级查询多条数据
    @GetMapping(value = "/findByClassId")
    public String findByClassId(@RequestParam("classId") String classId) {
        if ("".equals(classId) || classId == null) {
            return showData.showData(false, "专业不能为空");
        }
        return studentService.findByClassId(classId);
    }

    //根据id查询一条数据(2.0后不能使用findOne了)
    @GetMapping(value = "/findByStudentId")
    public String findByStudentId(@RequestParam("studentId") String studentId) {
        if ("".equals(studentId) || studentId == null) {
                return showData.showData(false, "请输入学号");
        }
        return studentService.findByStudentId(studentId);
    }

    //添加一个学生
    @PostMapping(path = "/addStudent")
    public String addStudent(@RequestParam("studentId") String studentId, @RequestParam("studentName") String studentName,
                             @RequestParam("sex") String sex, @RequestParam("studentCollege") String studentCollege,
                             @RequestParam("studentMajor") String studentMajor,@RequestParam("classId") String classId) {
        if ("".equals(studentId) || studentId == null || "".equals(studentName) || studentName == null
                || "".equals(sex) || sex == null|| "".equals(studentCollege) || studentCollege == null
                || "".equals(studentMajor) || studentMajor == null|| "".equals(classId) || classId == null) {
            return showData.showData(false, "请补全信息");
        }
        return studentService.addStudent(studentId, studentName, sex, studentCollege, studentMajor, classId);
    }

    //根据
    @PostMapping(path = "/deleteByStudentSelected")
    public String deleteByStudentSelected(@RequestParam("studentSelected") String[] studentSelected) {
        if(studentSelected.length == 0){
            return showData.showData(false, "请选择要删除的学生");
        }
        return studentService.deleteByStudentSelected(studentSelected);
    }

    //根据id删除一条数据
    @PostMapping(path = "/deleteByStudentId")
    public String deleteByStudentId(@RequestParam("studentId") String studentId) {
        if ("".equals(studentId) || studentId == null) {
            return showData.showData(false, "没有这个id");
        }
        return studentService.deleteByStudentId(studentId);
    }

}

