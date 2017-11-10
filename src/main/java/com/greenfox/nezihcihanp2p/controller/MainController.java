package com.greenfox.nezihcihanp2p.controller;

import com.greenfox.nezihcihanp2p.model.LogEntry;
import com.greenfox.nezihcihanp2p.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"","/"})
public class MainController {

    @Autowired
    LogRepository logRepository;

    @GetMapping({"","/"})
    public String chatMessage(){
        return "index";
    }

    @PostMapping("/login")
    public LogEntry home(HttpServletRequest request) {
        LogEntry logEntry = new LogEntry(request);
        logRepository.save(logEntry);
        System.out.println(logEntry);
        return logEntry;
    }
}
