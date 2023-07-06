package de.aittr.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String map(){
        return "hello_view";
    }

    @RequestMapping(value = "/second", method = RequestMethod.GET)
    public String map1(){
        return "second";
    }

}
