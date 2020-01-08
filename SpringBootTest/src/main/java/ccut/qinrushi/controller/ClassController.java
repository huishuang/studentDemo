package ccut.qinrushi.controller;

import ccut.qinrushi.service.ClassService;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ClassController {

    @Autowired
    ClassService classService;
    @Autowired
    ShowData showData;
    //查询所有
    @GetMapping(path = "/findAllClass")
    public String findAll() {
        return classService.findAll();
    }

    @GetMapping(value = "/findClassIdByMajorName")
    public String findByMajorName(@RequestParam("majorName") String majorName) {
        if ("".equals(majorName) || majorName == null) {
            return showData.showData(false, "请输入学号");
        }
        return classService.findByMajorName(majorName);
    }
}
