package com.ingxx.controller;

import com.github.pagehelper.PageInfo;
import com.ingxx.model.User;
import com.ingxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("selectAll")
    public ModelAndView selectAll(){
        ModelAndView modelAndView = new ModelAndView("user");
        List<User> users = userService.selectAll();
        modelAndView.addObject("userList",users);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("testPage")
    public Object testPage(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,@RequestParam(value = "pageSize",defaultValue = "5")int pageSize){
        PageInfo<User> page = userService.page(pageNumber, pageSize);
        Map<Object,Object> res = new HashMap<>();
        res.put("total",page.getTotal());
        res.put("rows",page.getList());
        return  res;
    }
}
