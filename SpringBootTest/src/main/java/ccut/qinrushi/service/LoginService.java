package ccut.qinrushi.service;

import ccut.qinrushi.dao.LoginDao;
import ccut.qinrushi.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ccut.qinrushi.util.ShowData;

@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;
    @Autowired
    ShowData showData;

    public String login(String userId,String password) {
        Login flag = loginDao.findByUserIdAndPassword(userId, password);
        if (flag == null) {
            return "null";
        }
        String a = flag.getUserId();
        String b = flag.getPassword();
        System.out.println("用户名：" + a + " 密码： " + b);
        if (a.equals(userId) && b.equals(password)) {
            return showData.showData(true,"登陆成功");
        } else {
            return showData.showData(false,"登录失败");
        }
    }
}
