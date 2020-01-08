package ccut.qinrushi.dao;

import ccut.qinrushi.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollegeDao extends JpaRepository<College,String> {

    List<College> findAll();
}
