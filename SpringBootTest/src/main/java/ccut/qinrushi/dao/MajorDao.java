package ccut.qinrushi.dao;

import ccut.qinrushi.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MajorDao extends JpaRepository<Major,String> {

    List<Major> findAll();

    List<Major> findByCollegeName(String collegeName);
}
