package ccut.qinrushi.entity;

import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departmentDemo")
public class Department {

    @Id
    @Column
    private String departmentId;
    @Column
    private String departmentName;

    public Department() {
    }

    public Department(String departmentId,String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("departmentId", departmentId);
        jsonObject.accumulate("departmentName", departmentName);
        return jsonObject.toString();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
