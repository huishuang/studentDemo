package ccut.qinrushi.controller;

import ccut.qinrushi.service.DepartmentService;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    ShowData showData;
    //查询所有
    @GetMapping(path = "/findAllDepartment")
    public String findAll() {
        return departmentService.findAll();
    }
}
