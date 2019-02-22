package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public Object login(User user) {
        System.out.println(user);
        System.out.println("进入登录");
        System.out.println(userService);
        User login = userService.login(user);
        System.out.println("查询完成");
        if (login != null) {
            System.out.println("开始返回到list");
            return "redirect:/user/showAll";
        } else return "redirect:/ems/login.jsp";
    }

    @RequestMapping("showAll")
    public Object showAll(HttpServletRequest req) {
        System.out.println("进入showall");
        List<User> list = userService.selectAll();
        System.out.println(list);
        req.setAttribute("list", list);
        System.out.println("开始跳转");
        return "emplist";
    }

    @RequestMapping("addUser")
    public Object addUser(User user) {
        userService.insert(user);
        return "redirect:/user/showAll";
    }

    @RequestMapping("delete")
    public Object delete(Integer id) {
        userService.deleteByPrimaryKey(id);
        return "redirect:/user/showAll";
    }
}
