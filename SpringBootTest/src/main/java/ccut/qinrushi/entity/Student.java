package ccut.qinrushi.entity;

import org.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name="studentDemo")
public class Student {

    @Id
    @Column(unique = true, length = 36)
    private String studentId;
    @Column(nullable = false)
    private String studentName;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false)
    private String studentCollege;
    @Column(nullable = false)
    private String studentMajor;
    @Column(nullable = false)
    private String classId;

    public Student() {
    }

    public Student(String studentId, String studentName, String sex, String studentCollege, String studentMajor, String classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.sex = sex;
        this.studentCollege = studentCollege;
        this.studentMajor = studentMajor;
        this.classId = classId;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("studentId", studentId);
        jsonObject.accumulate("studentName", studentName);
        jsonObject.accumulate("sex", sex);
        jsonObject.accumulate("studentCollege", studentCollege);
        jsonObject.accumulate("studentMajor", studentMajor);
        jsonObject.accumulate("classId", classId);
        return jsonObject.toString();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStudentCollege() {
        return studentCollege;
    }

    public void setStudentCollege(String studentCollege) {
        this.studentCollege = studentCollege;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}

