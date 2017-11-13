package com.greenfox.nezihcihanp2p.controller;

import com.greenfox.nezihcihanp2p.model.ErrorHandling;
import com.greenfox.nezihcihanp2p.model.Log;
import com.greenfox.nezihcihanp2p.model.LogChecker;
import com.greenfox.nezihcihanp2p.model.User;
import com.greenfox.nezihcihanp2p.repository.LogRepository;
import com.greenfox.nezihcihanp2p.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class MainController {

    @Autowired
    LogRepository logRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LogChecker logChecker;

//    @ExceptionHandler({MissingServletRequestParameterException.class,})
//    public ErrorHandling handleMyException(MissingServletRequestParameterException missingParam) {
//        ErrorHandling errorHandling = new ErrorHandling();
//        if(missingParam.getParameterName().equals("username")) {
//            errorHandling.setError("Please provide a username!");
//        }
//        return errorHandling;
//    }

    @GetMapping("/")
    public String main(HttpServletRequest request) {
        Log log = new Log(request);
        logRepository.save(log);
        logChecker.logMessageNoArg(request);
        return "index";
    }

    @GetMapping("/enter")
    public String newUser(HttpServletRequest request) {
        Log log = new Log(request);
        logRepository.save(log);
        logChecker.logMessageNoArg(request);
        return "enter";
    }

    @PostMapping("/enter")
    public ModelAndView enter(@RequestParam("username") String username,HttpServletRequest request) throws Exception {
        userRepository.save(new User(username));
        Log log = new Log(request);
        logRepository.save(log);
        logChecker.logMessageWithArg(request,username);
        return new ModelAndView("redirect:/");
    }
}
