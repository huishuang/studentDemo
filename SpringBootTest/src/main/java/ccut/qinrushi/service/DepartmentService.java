package ccut.qinrushi.service;

import ccut.qinrushi.dao.DepartmentDao;
import ccut.qinrushi.entity.Department;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    ShowData showData;

    //查询所有
    public String findAll(){
        List<Department> all = departmentDao.findAll();
        if (all.size() >= 1){
            return showData.showData(true,all.toString());
        }
        return showData.showData(false,"查询失败");
    }
}
