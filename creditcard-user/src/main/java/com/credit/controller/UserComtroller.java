package com.credit.controller;

import com.credit.pojo.TbBasicInfo;
import com.credit.pojo.TbCompanyInfo;
import com.credit.pojo.TbContactInfo;
import com.credit.pojo.TbUser;
import com.credit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserComtroller {

    @Autowired
    private UserService userService;

    /**
     * 发送手机验证码
     * @param phone
     * @return
     */
    @PostMapping("code")
    public Boolean sendVerifyCode(@RequestParam("phone") String phone) {
        return this.userService.sendVerifyCode(phone);
    }

    /**
     * 用户注册
     * @param user
     * @param code
     * @return
     */
    @PostMapping("register")
    public Boolean register(@Valid TbUser user, String code){
        return this.userService.register(user,code);
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public TbUser login(
            @RequestParam("username")String username,
            @RequestParam("password")String password){
        return this.userService.login(username,password);
    }

    /**
     * 更新密码
     * @param user
     * @param code
     * @return
     */
    @PostMapping("alterPassword")
    public Boolean alterPassword(TbUser user,
            @RequestParam("code")String code
    ){
        return this.userService.alterPassword(user,code);
    }

    /**
     * 根据uid查询基本信息
     * @param uid
     * @return
     */
    @GetMapping("queryBasic")
    public TbBasicInfo queryBasic(@RequestParam("uid")int uid){
        return this.userService.queryBasic(uid);
    }

    /**
     * 更新基本信息
     * @param basicInfo
     * @return
     */
    @PostMapping("updateBasic")
    public Boolean updateBasic(TbBasicInfo basicInfo){
        return this.userService.updateBasic(basicInfo);
    }

    /**
     *根据uid查询公司信息
     * @param uid
     * @return
     */
    @GetMapping("queryCompany")
    public TbCompanyInfo queryCompany(@RequestParam("uid")int uid){
        return this.userService.queryCompany(uid);
    }

    /**
     * 更新公司信息
     * @param companyInfo
     * @return
     */
    @PostMapping("updateBasic")
    public Boolean updateCompany(TbCompanyInfo companyInfo){
        return this.userService.updateCompany(companyInfo);
    }

    /**
     *根据uid查询联系人信息
     * @param uid
     * @return
     */
    @GetMapping("queryContact")
    public TbContactInfo queryContact(@RequestParam("uid")int uid){
        return this.userService.queryContact(uid);
    }

    /**
     * 更新联系人信息
     * @param contactInfo
     * @return
     */
    @PostMapping("updateBasic")
    public Boolean updateBasic(TbContactInfo contactInfo){
        return this.userService.updateContact(contactInfo);
    }

}
