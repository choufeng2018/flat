package com.xsm.flat.controller;

import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Province;
import com.xsm.flat.entity.User;
import com.xsm.flat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * admin,用户信息表管理，查询出所有的用户。
     * @return
     */
    @RequestMapping(value = "/selectall", method = RequestMethod.GET)
    public AjaxResponse selectUser(){
        List<User> list = userService.getUsers();
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,list);
        return res;
    }

    /**
     * admin，用户信息表管理，更新相应记录
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public  AjaxResponse updateUser(User user) {

        userService.updateUser(user);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public  AjaxResponse deleteUser(User user) {

        userService.deleteUser(user);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public  AjaxResponse addUser(User user) {

        userService.addUser(user);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }
}
