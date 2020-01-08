package ccut.qinrushi.controller;

import ccut.qinrushi.entity.Schedule;
import ccut.qinrushi.service.ScheduleService;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;
    @Autowired
    ShowData showData;
    //查询所有
    @GetMapping(path = "/findAllSchedule")
    public String findAll() {
        return scheduleService.findAll();
    }

    //根据id查询一条数据(2.0后不能使用findOne了)
    @GetMapping(value = "/findScheduleByStudentId")
    public String findByStudentId(@RequestParam("studentId") String studentId) {
        if ("".equals(studentId) || studentId == null) {
            return showData.showData(false, "请输入学号");
        }
        return scheduleService.findByStudentId(studentId);
    }

    //根据id查询一条数据(2.0后不能使用findOne了)
    @GetMapping(value = "/findAllScheduleByStudentId")
    public String findAllByStudentId(@RequestParam("studentId") String studentId) {
        if ("".equals(studentId) || studentId == null) {
            return showData.showData(false, "请输入学号");
        }
        return scheduleService.findAllByStudentId(studentId);
    }

    //根据部门和流程、学号查询
    @GetMapping(path="/findByDepartmentNameAndScheduleNameAndStudentId")
    public String findByDepartmentNameAndScheduleNameAndStudentId(@RequestParam("departmentName") String departmentName,
                                                                  @RequestParam("scheduleName") String scheduleName,
                                                                  @RequestParam("studentId") String studentId) {
        if ("".equals(departmentName) || departmentName == null || "".equals(scheduleName) || scheduleName == null) {
            return showData.showData(false, "请补全信息");
        }
        return scheduleService.findByDepartmentNameAndScheduleNameAndStudentId(departmentName, scheduleName, studentId);
    }

    @PostMapping(path = "/addFlow")
    public String addStudent(@RequestParam("departmentName") String departmentName, @RequestParam("scheduleName") String scheduleName,
                             @RequestParam("studentId") String studentId) {
        if ("".equals(departmentName) || departmentName == null || "".equals(scheduleName) || scheduleName == null
                || "".equals(studentId) || studentId == null) {
            return showData.showData(false, "请补全信息");
        }
        return scheduleService.addFlow(departmentName, scheduleName, studentId);
    }

//    @GetMapping(value = "/hasExits/{studentId}")
//    public List<Schedule> hasExits(@RequestParam("studentId") String studentId) {
//        List<Schedule> schedules = scheduleService.hasExits(studentId);
//        return schedules;
//    }
}
