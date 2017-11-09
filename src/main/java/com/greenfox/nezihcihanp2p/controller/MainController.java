package com.greenfox.nezihcihanp2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"","/"})
public class MainController {

    @GetMapping({"","/"})
    public String chatMessage(){
        return "index";
    }
}
