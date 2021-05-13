package com.it.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/1/13
 */
@Controller
@RequestMapping("/annotation")
public class AnnotationController {
    @RequestMapping("/testParam")
    public String testRequestParam(@RequestParam(value = "name") String username){
        System.out.println("testRequestParam........"+username);
        return "success";
    }


    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String queryStr){
        System.out.println("queryStr="+queryStr);
        return "success";
    }
}
