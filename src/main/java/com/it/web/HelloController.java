package com.it.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/1/13
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/hello")
    public String sayHello(){
        System.out.println("HelloController 的 sayHello 方法执行了。。。。 ");
        return "success";
    }
}
