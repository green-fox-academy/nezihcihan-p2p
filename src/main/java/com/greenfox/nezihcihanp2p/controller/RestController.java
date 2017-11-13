package com.greenfox.nezihcihanp2p.controller;

import com.greenfox.nezihcihanp2p.model.Log;
import com.greenfox.nezihcihanp2p.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    LogRepository logRepository;
    @Autowired
    Log log;

    @GetMapping(value = "/log")
    public List<Log> getLogHistory() {
        List<Log> entries = new ArrayList<>();
        for (Log e : logRepository.findAll()) {
            entries.add(e);
        }
        return entries;
    }
}
