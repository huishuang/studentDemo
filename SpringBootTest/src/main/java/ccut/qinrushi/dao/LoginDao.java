package ccut.qinrushi.dao;

import ccut.qinrushi.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDao extends JpaRepository<Login,String> {
    Login findByUserIdAndPassword(String userId,String password);
}
