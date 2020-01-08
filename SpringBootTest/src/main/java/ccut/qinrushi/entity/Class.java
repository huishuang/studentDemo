package ccut.qinrushi.entity;

import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classDemo")
public class Class {

    @Id
    @Column
    private String classId;
    @Column
    private String collegeName;
    @Column
    private String majorName;

    public Class() {}

    public Class(String classId, String collegeName, String majorName) {
        this.classId = classId;
        this.collegeName = collegeName;
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("classId", classId);
        jsonObject.accumulate("collegeName", collegeName);
        jsonObject.accumulate("majorName", majorName);
        return jsonObject.toString();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
