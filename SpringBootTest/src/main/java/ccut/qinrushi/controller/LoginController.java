package ccut.qinrushi.controller;

import ccut.qinrushi.service.LoginService;
import ccut.qinrushi.util.ShowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController{

    @Autowired
    LoginService loginService;
    @Autowired
    ShowData showData;

    @PostMapping(path = "/login")
    public String login(@RequestParam("userId") String userId, @RequestParam("password") String password) {
        if ("".equals(userId) || password == null) {
            return showData.showData(false, "请输入用户名和密码");
        }
        return loginService.login(userId,password);
    }
}
