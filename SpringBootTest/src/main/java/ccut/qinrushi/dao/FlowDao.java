package ccut.qinrushi.dao;

import ccut.qinrushi.entity.Flow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowDao extends JpaRepository<Flow,String> {

    List<Flow> findAll();

    List<Flow> findByDepartmentName(String departmentName);

    List<Flow> findByDepartmentNameAndScheduleName(String departmentName, String scheduleName);
}
