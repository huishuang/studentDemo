package ccut.qinrushi.dao;

import ccut.qinrushi.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentDao extends JpaRepository<Department,String> {

    List<Department> findAll();
}
