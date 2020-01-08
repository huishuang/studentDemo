package ccut.qinrushi.service;

import ccut.qinrushi.dao.MajorDao;
import ccut.qinrushi.entity.Major;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MajorService {

    @Autowired
    private MajorDao majorDao;
    @Autowired
    ShowData showData;

    //查询所有
    public String findAll(){
        List<Major> all = majorDao.findAll();
        if (all.size() >= 1){
            return showData.showData(true,all.toString());
        }
        return showData.showData(false,"查询失败");
    }

    public String findByStudentCollege(String collegeName){
        List<Major> byCollegeName = majorDao.findByCollegeName(collegeName);
        if (byCollegeName.size() >= 1){
            return showData.showData(true,byCollegeName.toString());
        }
        return showData.showData(false,"学生不存在");
    }
}
