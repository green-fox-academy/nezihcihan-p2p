package com.greenfox.nezihcihanp2p.model;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class LogChecker {

    public boolean logIsInfo() {
        return System.getenv("CHAT_APP_LOGLEVEL").equals("INFO");
    }
    public void logMessageNoArg(HttpServletRequest request) {
        Log log = new Log(request);
        if(logIsInfo() == true) {
            String logMessage = log.toString();
            System.out.println(logMessage);
        }
        else {
            log.setLogLevel("ERROR");
            String logMessage = log.toString();
            System.err.println(logMessage);
        }
    }
    public void logMessageWithArg(HttpServletRequest request, String requestData) {
        if(logIsInfo() == false) {
            Log log =new Log(request,requestData);
            String logMessage = log.toString();
            System.out.println(logMessage);
        }
    }
}
