package com.greenfox.nezihcihanp2p.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.Logger;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping({""})
public class MainController {


//    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
//    Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());


    @GetMapping({"","/"})
    public String main(HttpServletRequest request){
        Logger.showLogNoParam(request);
        return "index";
    }
}
