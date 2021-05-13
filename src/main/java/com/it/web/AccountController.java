package com.it.web;

import com.it.pojo.Account;
import com.it.pojo.User;
import com.it.pojo.User02;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/1/13
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @RequestMapping(value = "/add")
    public String add(String name,Integer age){//注意此处的形参名要和请求中的名称一致
        System.out.println("AccountController ....add()");
        System.out.println(name+":"+age);
        return "success";
    }

    @RequestMapping(value = "/update")
    public String update(Account account){//形参名就用pojo,注意pojo的属性要和请求参数中一致
        System.out.println("AccountController ....update()");
        System.out.println(account);
        return "success";
    }


    @RequestMapping(value = "/delete")
    public String delete(User user){//形参名就用pojo,注意pojo的属性要和请求参数中一致
        System.out.println("AccountController ....delete()");
        System.out.println(user);
        return "success";
    }



    @RequestMapping("/findAll")
    public String findAll(User02 user02) {
        System.out.println("查询账户..."+user02);
        return "success";
    }


}
