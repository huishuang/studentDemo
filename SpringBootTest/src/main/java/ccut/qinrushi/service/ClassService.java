package ccut.qinrushi.service;

import ccut.qinrushi.dao.ClassDao;
import ccut.qinrushi.entity.Class;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassDao classDao;
    @Autowired
    ShowData showData;

    //查询所有
    public String findAll(){
        List<Class> all = classDao.findAll();
        if (all.size() >= 1){
            return showData.showData(true,all.toString());
        }
        return showData.showData(false,"查询失败");
    }

    public String findByMajorName(String majorName){
        List<Class> byMajorName = classDao.findByMajorName(majorName);
        if (byMajorName.size() >= 1){
            return showData.showData(true,byMajorName.toString());
        }
        return showData.showData(false,"学生不存在");
    }
}
