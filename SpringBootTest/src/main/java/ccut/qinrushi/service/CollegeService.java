package ccut.qinrushi.service;

import ccut.qinrushi.dao.CollegeDao;
import ccut.qinrushi.entity.College;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeDao collegeDao;
    @Autowired
    ShowData showData;

    //查询所有
    public String findAll(){
        List<College> all = collegeDao.findAll();
        if (all.size() >= 1){
            return showData.showData(true,all.toString());
        }
        return showData.showData(false,"查询失败");
    }
}
