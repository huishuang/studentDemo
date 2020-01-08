package ccut.qinrushi.dao;

import ccut.qinrushi.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassDao extends JpaRepository<Class,String> {

    List<Class> findAll();

    List<Class> findByMajorName(String majorName);
}
