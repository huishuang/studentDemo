package ccut.qinrushi.entity;

import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "majorDemo")
public class Major {

    @Id
    @Column
    private String majorId;
    @Column
    private String majorName;
    @Column
    private String collegeName;

    public Major() {}

    public Major(String majorId, String majorName, String collegeName) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("majorId", majorId);
        jsonObject.accumulate("majorName", majorName);
        jsonObject.accumulate("collegeName", collegeName);
        return jsonObject.toString();
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
