package com.greenfox.nezihcihanp2p.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    private Timestamp date;
    private String logLevel;
    private String path;
    private String method;
    private String requestData;

    public Log(String path, String method, String requestData) {
        this.path = path;
        this.method = method;
        this.requestData = requestData;
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public Log(String path, String method) {
        this.path = path;
        this.method = method;
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public void showLog() {
        if (this.requestData == null) {
            System.out.println(this.date + " " + this.logLevel + " " + this.method + " " + this.path);
        } else {
            System.out.println(this.date + " " + this.logLevel + " " + this.method + " " + this.path + " " + this.requestData);
        }
    }
    public static void showLogWithNoParameter(HttpServletRequest request) {
        new Log(request.getRequestURI(), request.getMethod()).showLog();
    }
}
