package com.greenfox.nezihcihanp2p.model;


import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntry {

    String path;
    String method;
    String date;
    String logLevel;
    String requestData;

    public LogEntry(HttpServletRequest request) {
        this.path = request.getContextPath();
        this.method = request.getMethod();
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
        this.requestData = request.getQueryString();
    }

    public LogEntry() {
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "LogEntry{" +
                "path='" + path + '\'' +
                ", method='" + method + '\'' +
                ", date='" + date + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", requestData='" + requestData + '\'' +
                '}';
    }
}
