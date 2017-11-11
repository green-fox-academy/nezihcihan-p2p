package com.greenfox.nezihcihanp2p.model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;
import java.security.Timestamp;
import java.util.Date;

public class Log {

    private String path;
    private String method;
//    private Timestamp dateAndTime;
    private String logLevel;
    private String requestData;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAndTime;
    public Log(HttpServletRequest request) {
    }

    public Log(String path,String method, String requestData) {
        this.path = path;
        this.method = method;
        this.requestData = requestData;
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
        this.dateAndTime = new Date();
    }

    //    public LogEntry(HttpServletRequest request) {
//        this.path = request.getContextPath();
//        this.method = request.getMethod();
//        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
//        this.requestData = request.getQueryString();
//    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void showLog() {
        if (this.requestData == null) {
            System.out.println(this.dateAndTime + " " + this.logLevel + " " + this.method + " " + this.path);
        } else {
            System.out.println(this.dateAndTime + " " + this.logLevel + " " + this.method + " " + this.path + " " + this.requestData);
        }
    }
}
