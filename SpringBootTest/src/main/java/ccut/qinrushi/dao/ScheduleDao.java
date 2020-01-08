package ccut.qinrushi.dao;

import ccut.qinrushi.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleDao extends JpaRepository<Schedule,String> {

    List<Schedule> findAll();

    List<Schedule> findByStudentId(String studentId);

    List<Schedule> findByDepartmentNameAndScheduleNameAndStudentId(String departmentName, String scheduleName, String studentId);

//    List<Schedule> hasExits(String studentId);
}
