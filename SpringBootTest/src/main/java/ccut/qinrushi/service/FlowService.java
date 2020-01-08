package ccut.qinrushi.service;

import ccut.qinrushi.dao.FlowDao;
import ccut.qinrushi.entity.Flow;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class FlowService {

    @Autowired
    private FlowDao flowDao;
    @Autowired
    ShowData showData;

    //查询所有
    public String findAll(){
        List<Flow> all = flowDao.findAll();
        if (all.size() >= 1){
            return showData.showData(true,all.toString());
        }
        return showData.showData(false,"查询失败");
    }

    public String findByDepartmentName(String departmentName){
        List<Flow> byDepartmentName = flowDao.findByDepartmentName(departmentName);
        if (byDepartmentName.size() >= 1){
            return showData.showData(true,byDepartmentName.toString());
        }
        return showData.showData(false,"学生不存在");
    }

    public String findByDepartmentNameAndScheduleName(String departmentName, String scheduleName){
        List<Flow> byDepartmentNameAndScheduleName = flowDao.findByDepartmentNameAndScheduleName(departmentName, scheduleName);
        if (byDepartmentNameAndScheduleName.size() == 1){
            return showData.showData(true,byDepartmentNameAndScheduleName.toString());
        }
        return showData.showData(false,"学生不存在");
    }
}
