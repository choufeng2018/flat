package com.xsm.flat.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsm.flat.base.AjaxResponse;
import com.xsm.flat.entity.Admin;
import com.xsm.flat.entity.Province;
import com.xsm.flat.entity.User;
import com.xsm.flat.service.AdminService;
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

    @Autowired
    private AdminService adminService;

    /**
     * admin,用户信息表管理，查询出所有的用户。
     * @return
     */
    @RequestMapping(value = "/selectall", method = RequestMethod.GET)
    public AjaxResponse selectUser(Integer pageNum,
                                   Integer pageSize){
        List<User> records = userService.getUsers(pageNum,pageSize);
        PageInfo<User> page = new PageInfo<User>(records);
        AjaxResponse res= new AjaxResponse();
        res.setSuccessMessage(true,records);
        res.setPage(page);
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

    /**
     * admin 删除用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public  AjaxResponse deleteUser(User user) {

        userService.deleteUser(user);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

    /**
     *
     * client 注册接口，admin 添加用户接口
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public  AjaxResponse addUser(User user) {

        userService.addUser(user);
        AjaxResponse res = new AjaxResponse();
        res.setSuccessMessageUpdate();
        return res;
    }

    /**
     * admin 管理员登录验证
     * @param admin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public  Boolean loginCheck(Admin admin) {

        Boolean result = adminService.loginCheck(admin);
        return result;
    }

    /**
     * client 用户登录校验
     * @param user
     * @return
     */
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public Boolean userLoginCheck (User user){

        Boolean result = userService.userLoginCheck(user);
        return result;
    }

}
