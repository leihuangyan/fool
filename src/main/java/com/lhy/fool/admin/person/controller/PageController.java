package com.lhy.fool.admin.person.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @name: PageController
 * @author： 98403
 * @classPath: com.lhy.fool.admin.person.controller.PageController
 * @date: 2019-07-28 03:52
 * @Version: 1.0
 * @description: TODO
 */
@Controller
public class PageController {

    @GetMapping("/index")
    public  String index (){
        return  "index";
    }


    @GetMapping("/test")
    public  String test (){
        return  "test";
    }
}
