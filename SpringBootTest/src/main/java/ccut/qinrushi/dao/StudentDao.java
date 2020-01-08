package ccut.qinrushi.dao;


import ccut.qinrushi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//泛型中第一个参数是实体类，第二个是id类型
public interface StudentDao extends JpaRepository<Student,String> {

     List<Student> findAll();

     List<Student> findByStudentCollegeAndStudentMajorAndClassIdAndStudentId(String studentCollege, String studentMajor, String classId, String studentId);

     List<Student> findByStudentCollegeAndStudentMajorAndClassId(String studentCollege, String studentMajor, String classId);

     List<Student> findByStudentCollegeAndClassId(String studentCollege, String classId);

     List<Student> findByStudentCollegeAndStudentMajor(String studentCollege, String studentMajor);

     List<Student> findByStudentCollege(String studentCollege);

     List<Student> findByStudentMajor(String studentMajor);

     List<Student> findByClassId(String classId);

     List<Student> findByStudentId(String studentId);

     void deleteByStudentId(String studentId);

}
