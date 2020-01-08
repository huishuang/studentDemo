package ccut.qinrushi.entity;

import org.json.JSONObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacherDemo")
public class Teacher {

    @Id
    @Column
    private String teacherId;
    @Column
    private String teacherName;
    @Column
    private String sex;
    @Column
    private String teacherCollege;
    @Column
    private String teacherMajor;

    public Teacher(){

    }

    public Teacher(String teacher_id,String teacher_name,String sex,String teacher_college,String teacher_major){
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.sex = sex;
        this.teacherCollege = teacherCollege;
        this.teacherMajor = teacherMajor;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("teacherId",teacherId);
        jsonObject.accumulate("teacherName",teacherName);
        jsonObject.accumulate("sex",sex);
        jsonObject.accumulate("teacherCollege",teacherCollege);
        jsonObject.accumulate("teacherMajor",teacherMajor);
        return jsonObject.toString();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTeacherCollege() {
        return teacherCollege;
    }

    public void setTeacherCollege(String teacherCollege) {
        this.teacherCollege = teacherCollege;
    }

    public String getTeacherMajor() {
        return teacherMajor;
    }

    public void setTeacherMajor(String teacherMajor) {
        this.teacherMajor = teacherMajor;
    }
}
