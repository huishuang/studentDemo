package ccut.qinrushi.entity;

import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flowDemo")
public class Flow {

    @Id
    @Column
    private String scheduleId;
    @Column
    private String scheduleName;
    @Column
    private String departmentName;

    public Flow() {
    }

    public Flow(String scheduleId, String scheduleName, String departmentName){
        this.scheduleId = scheduleId;
        this.scheduleName = scheduleName;
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("scheduleId", scheduleId);
        jsonObject.accumulate("scheduleName", scheduleName);
        jsonObject.accumulate("departmentName", departmentName);
        return jsonObject.toString();
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
