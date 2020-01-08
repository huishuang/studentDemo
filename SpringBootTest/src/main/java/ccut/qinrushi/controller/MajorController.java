package ccut.qinrushi.controller;

import ccut.qinrushi.entity.Major;
import ccut.qinrushi.service.MajorService;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MajorController {

    @Autowired
    MajorService majorService;
    @Autowired
    ShowData showData;
    //查询所有
    @GetMapping(path = "/findAllMajor")
    public String findAll() {
        return majorService.findAll();
    }

    @GetMapping(value = "/findMajorByCollegeName")
    public String findByStudentCollege(@RequestParam("collegeName") String collegeName) {
        if ("".equals(collegeName) || collegeName == null) {
            return showData.showData(false, "请输入学号");
        }
        return majorService.findByStudentCollege(collegeName);
    }
}
