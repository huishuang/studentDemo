package ccut.qinrushi.controller;

import ccut.qinrushi.entity.College;
import ccut.qinrushi.service.CollegeService;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CollegeController {

    @Autowired
    CollegeService collegeService;
    @Autowired
    ShowData showData;
    //查询所有
    @GetMapping(path = "/findAllCollege")
    public String findAll() {
        return collegeService.findAll();
    }
}
