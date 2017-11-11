package com.greenfox.nezihcihanp2p.controller;

import com.greenfox.nezihcihanp2p.model.Log;
import com.greenfox.nezihcihanp2p.model.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({""})
public class MainController {

//    @Autowired
//    LogRepository logRepository;
//    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());


    @GetMapping({"","/"})
    public String chatMessage(){
        return "index";
    }

//    @PostMapping("/savemessage")
//    public Message postMessage(RequestParam("message") String message) {
//        Message firstMessage = new Message(message);
//        messageRepository.save(firstMessage);
//        return firstMessage;
//    }
//
//    @RequestMapping("/login")
//    public Log home(HttpServletRequest request) {
//        Log log= new Log(request);
//        logRepository.save(log);
//        System.out.println(log);
//        return log;
//    }
}
