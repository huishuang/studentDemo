package ccut.qinrushi.entity;

import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scheduleDemo")
public class Schedule {

    @Id
    @Column
    private String scheduleId;
    @Column
    private String departmentName;
    @Column
    private String scheduleName;
    @Column
    private String studentId;

    public Schedule() {
    }

    public Schedule(String scheduleId, String departmentName, String scheduleName, String studentId){
        this.scheduleId = scheduleId;
        this.departmentName = departmentName;
        this.scheduleName = scheduleName;
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("scheduleId", scheduleId);
        jsonObject.accumulate("departmentName", departmentName);
        jsonObject.accumulate("scheduleName", scheduleName);
        jsonObject.accumulate("studentId", studentId);
        return jsonObject.toString();
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
