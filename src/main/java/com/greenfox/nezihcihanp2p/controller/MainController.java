package com.greenfox.nezihcihanp2p.controller;

import com.greenfox.nezihcihanp2p.model.*;
import com.greenfox.nezihcihanp2p.repository.MessageRepository;
import com.greenfox.nezihcihanp2p.service.LogChecker;
import com.greenfox.nezihcihanp2p.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Controller
@RequestMapping("")
public class MainController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    LogChecker logChecker;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    User user;

    RestTemplate template = new RestTemplate();

    @GetMapping("/")
    public String main(HttpServletRequest request, Model model) {
        model.addAttribute("users", userRepository.findAll());
        logChecker.printNormalLog(request);
        model.addAttribute("messages", messageRepository.findAllByOrderByTimestampDesc());
        model.addAttribute("username", user.getUsername());

        return "index";
    }
    @GetMapping("/enter")
    public String newUser(HttpServletRequest request) {
        logChecker.printNormalLog(request);
        return "enter";
    }
    @PostMapping("/create")
    public String enter(HttpServletRequest request,String username, Model model) {
        logChecker.printNormalLog(request);
        if (!StringUtils.isEmpty(username)) {
            user.setId(1L);
            user.setUsername(username);
            userRepository.save(user);
            return "redirect:/";
        }
        else {
        logChecker.printErrorLog(request);
        String errorMessage = "The username field is empty";
        user.setUsername("");
        model.addAttribute("error", errorMessage);
        return "enter";
        }
    }
    //UPDATE USERNAME
    @GetMapping("/{id}/edit")
    public String edit(HttpServletRequest request,@PathVariable long id, Model model) {
        logChecker.printNormalLog(request);
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        userRepository.equals(user);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEntry(HttpServletRequest request, @ModelAttribute User user){
        logChecker.printNormalLog(request);
        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/savemessage")
    public Object create(HttpServletRequest request, @RequestParam("chatmessage") String chatmessage) {
        logChecker.printNormalLog(request);
        Message myMessage = new Message();
        myMessage.setUsername(user.getUsername());
        myMessage.setText(chatmessage);
        myMessage.setTimestamp(new Timestamp(System.currentTimeMillis()));
        messageRepository.save(myMessage);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ReceivedMessage receivedMessage = new ReceivedMessage(chatmessage, new Client("nezihcihan"));
//        Response response= restTemplate.postForObject("http://localhost:8080/api/message/receive", Response.class);
      return "redirect:/";
    }
}
