package com.greenfox.nezihcihanp2p.controller;

import com.greenfox.nezihcihanp2p.model.Log;
import com.greenfox.nezihcihanp2p.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({""})
public class MainController {

    @Autowired
    LogRepository logRepository;
    @Autowired
    Log log;

    @RequestMapping("/main")
    public String main( HttpServletRequest request) {
        logRepository.save(new Log(request));
        new Log(request).printLog();
//        if (userRepository.count() == 0) {
//            return "redirect:/enter";
//        } else {
//            model.addAttribute("error", errorTextOnWebPage);
//            model.addAttribute("userName", userRepository.findOne((long) 1).getName());
//            model.addAttribute("messageList", messageRepository.findAll());
            return "index";
//        }
    }



}