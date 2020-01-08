package ccut.qinrushi.service;

import ccut.qinrushi.dao.FlowDao;
import ccut.qinrushi.dao.ScheduleDao;
import ccut.qinrushi.entity.Flow;
import ccut.qinrushi.entity.Schedule;
import ccut.qinrushi.util.ShowData;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private FlowDao flowDao;
    @Autowired
    ShowData showData;

    //查询所有
    public String findAll(){
        List<Schedule> all = scheduleDao.findAll();
        if (all.size() >= 1){
            return showData.showData(true,all.toString());
        }
        return showData.showData(false,"查询失败");
    }

    //根据id查询一条数据(2.0后不能使用findOne了)
    public String findByStudentId(String studentId){
        List<Schedule> byStudentId = scheduleDao.findByStudentId(studentId);
        int number = byStudentId.size();
        JSONArray jsonArray = null;
        jsonArray = new JSONArray(byStudentId);
        if (byStudentId.size() >= 1) {
            String departmentName = (String) jsonArray.getJSONObject(number-1).get("departmentName");
            return showData.showData(true, departmentName);
        } else{
            return showData.showData(true, "招生办");
        }
    }

    //根据id查询一条数据(2.0后不能使用findOne了)
    public String findAllByStudentId(String studentId){
        List<Schedule> byStudentId = scheduleDao.findByStudentId(studentId);
        if (byStudentId.size() >= 1){
            return showData.showData(true,byStudentId.toString());
        }
        return showData.showData(false,"学生不存在");
    }

    //根据部门名称和流程名称和学号查询
    public String findByDepartmentNameAndScheduleNameAndStudentId(String departmentName, String scheduleName, String studentId){
        List<Schedule> byDepartmentNameAndScheduleNameAndStudentId = scheduleDao.findByDepartmentNameAndScheduleNameAndStudentId(departmentName, scheduleName, studentId);
        if (byDepartmentNameAndScheduleNameAndStudentId.size() == 1){
            return showData.showData(true,byDepartmentNameAndScheduleNameAndStudentId.toString());
        }
        return showData.showData(false,"学生不存在");
    }

    //插入一个学生
    public String  addFlow(String departmentName, String scheduleName, String studentId){
        List<Schedule> byDepartmentNameAndScheduleNameAndStudentId = scheduleDao.findByDepartmentNameAndScheduleNameAndStudentId(departmentName, scheduleName, studentId);
        List<Flow> byDepartmentNameAndScheduleName = flowDao.findByDepartmentNameAndScheduleName(departmentName, scheduleName);
        List<Schedule> byStudentId = scheduleDao.findByStudentId(studentId);
        JSONArray jsonArray = null;
        jsonArray = new JSONArray(byDepartmentNameAndScheduleName);
        String scheduleId = (String) jsonArray.getJSONObject(0).get("scheduleId");
        if(String.valueOf(byStudentId.size()+1).equals(scheduleId)) {
            Schedule flow = new Schedule(scheduleId, departmentName, scheduleName, studentId);
            Schedule save = scheduleDao.save(flow);
            List<Schedule> all = scheduleDao.findAll();
            return showData.showData(true,all.toString());
        } else if (byDepartmentNameAndScheduleNameAndStudentId.size() == 1){
            return showData.showData(false,"学生已办完此流程,请办理"+(byStudentId.size()+1)+"流程");
        } else {
            return showData.showData(false,"请按顺序办理流程");
        }
    }

}
