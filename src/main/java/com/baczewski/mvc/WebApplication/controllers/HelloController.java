package com.baczewski.mvc.WebApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String sayHello() {
        return "index";
    }

//    @RequestMapping("/{name}")
//    public String sayHelloToYou(
//            Model model,
//        @PathVariable String name)
//    {
//        model.addAttribute("visitor", name);
//        return "index";
//    }

}
