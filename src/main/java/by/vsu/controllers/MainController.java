package main.java.by.vsu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/help")
    public String help() {
        return "help";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

}
