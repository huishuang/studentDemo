package ccut.qinrushi.service;

import ccut.qinrushi.dao.StudentDao;
import ccut.qinrushi.entity.Student;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    ShowData showData;

    //查询所有
    public String findAll(){
        List<Student> all = studentDao.findAll();
        if (all.size() >= 1){
            return showData.showData(true,all.toString());
        }
        return showData.showData(false,"查询失败");
    }

    //根据学院、专业、班级、学号查询
    public String findByStudentCollegeAndStudentMajorAndClassIdAndStudentId(String studentCollege, String studentMajor, String classId, String studentId){
        List<Student> byStudentCollegeAndStudentMajorAndClassIdAndStudentId = studentDao.findByStudentCollegeAndStudentMajorAndClassIdAndStudentId(studentCollege, studentMajor, classId, studentId);
        if (byStudentCollegeAndStudentMajorAndClassIdAndStudentId.size() == 1){
            return showData.showData(true,byStudentCollegeAndStudentMajorAndClassIdAndStudentId.toString());
        }
        return showData.showData(false,"学生不存在");
    }

    //根据学院、专业、班级查询
    public String findByStudentCollegeAndStudentMajorAndClassId(String studentCollege, String studentMajor, String classId){
        List<Student> byStudentCollegeAndStudentMajorAndClassId = studentDao.findByStudentCollegeAndStudentMajorAndClassId(studentCollege, studentMajor, classId);
        if (byStudentCollegeAndStudentMajorAndClassId.size() >= 1){
            return showData.showData(true,byStudentCollegeAndStudentMajorAndClassId.toString());
        }
        return showData.showData(false,"学生不存在");
    }

    //根据学院、班级查询
    public String findByStudentCollegeAndClassId(String studentCollege, String classId){
        List<Student> byStudentCollegeAndClassId = studentDao.findByStudentCollegeAndClassId(studentCollege, classId);
        if (byStudentCollegeAndClassId.size() >= 1){
            return showData.showData(true,byStudentCollegeAndClassId.toString());
        }
        return showData.showData(false,"学生不存在");
    }

    //根据学院、专业查询
    public String findByStudentCollegeAndStudentMajor(String studentCollege, String studentMajor){
        List<Student> byStudentCollegeAndStudentMajor = studentDao.findByStudentCollegeAndStudentMajor(studentCollege, studentMajor);
        if (byStudentCollegeAndStudentMajor.size() >= 1){
            return showData.showData(true,byStudentCollegeAndStudentMajor.toString());
        }
        return showData.showData(false,"学生不存在");
    }

    //根据学生学院查询多条数据
    public String findByStudentCollege(String studentCollege){
        List<Student> byCollege = studentDao.findByStudentCollege(studentCollege);
        if (byCollege.size() >= 1){
            return showData.showData(true,byCollege.toString());
        }
        return showData.showData(false,"查询失败");
    }

    //根据学生专业查询多条数据
    public String findByStudentMajor(String studentMajor){
        List<Student> byMajor = studentDao.findByStudentMajor(studentMajor);
        if (byMajor.size() >= 1){
            return showData.showData(true,byMajor.toString());
        }
        return showData.showData(false,"查询失败");
    }

    //根据学生班级查询多条数据
    public String findByClassId(String classId){
        List<Student> byClass = studentDao.findByClassId(classId);
        if (byClass.size() >= 1){
            return showData.showData(true,byClass.toString());
        }
        return showData.showData(false,"查询失败");
    }

    //根据id查询一条数据(2.0后不能使用findOne了)
    public String findByStudentId(String studentId){
        List<Student> byStudentId = studentDao.findByStudentId(studentId);
        if (byStudentId.size() == 1){
            return showData.showData(true,byStudentId.toString());
        }
        return showData.showData(false,"学生不存在");
    }

    //插入一个学生
    public String  addStudent(String studentId, String studentName, String sex, String studentCollege, String studentMajor, String classId){
        List<Student> byStudentId = studentDao.findByStudentId(studentId);
        if(byStudentId.size() == 1){
            return showData.showData(false,"学生已存在");
        }
        Student student = new Student(studentId, studentName, sex, studentCollege, studentMajor, classId);
        Student save = studentDao.save(student);
        List<Student> all = studentDao.findAll();
        return showData.showData(true,all.toString());
    }

    //根据删除多项
    @Transactional
    public String deleteByStudentSelected(String[] studentSelected){
        for (int i=0;i<studentSelected.length;i++){
            studentDao.deleteByStudentId(studentSelected[i]);
        }
        List<Student> all = studentDao.findAll();
        return showData.showData(true,all.toString());
    }

    //根据id删除一条数据
    @Transactional
    public String deleteByStudentId(String student_id){
        List<Student> byStudentId = studentDao.findByStudentId(student_id);
        if (byStudentId.size() == 1){
            studentDao.deleteByStudentId(student_id);
            List<Student> all = studentDao.findAll();
            return showData.showData(true,all.toString());
        }
        return showData.showData(false,"删除失败");
    }

}
