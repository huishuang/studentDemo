package ccut.qinrushi.controller;

import ccut.qinrushi.service.FlowService;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class FlowController {

    @Autowired
    FlowService flowService;
    @Autowired
    ShowData showData;
    //查询所有
    @GetMapping(path = "/findAllFlow")
    public String findAll() {
        return flowService.findAll();
    }

    @GetMapping(value = "/findByDepartmentName")
    public String findByDepartmentName(@RequestParam("departmentName") String departmentName) {
        if ("".equals(departmentName) || departmentName == null) {
            return showData.showData(false, "部门不能为空");
        }
        return flowService.findByDepartmentName(departmentName);
    }

    @GetMapping(value = "/findByDepartmentNameAndScheduleName")
    public String findByDepartmentNameAndScheduleName(@RequestParam("departmentName") String departmentName,
                                                  @RequestParam("scheduleName") String scheduleName) {
        if ("".equals(departmentName) || departmentName == null || "".equals(scheduleName) || scheduleName == null) {
            return showData.showData(false, "部门、流程不能为空");
        }
        return flowService.findByDepartmentNameAndScheduleName(departmentName,scheduleName);
    }
}
