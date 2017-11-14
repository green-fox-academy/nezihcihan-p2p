package com.greenfox.nezihcihanp2p.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;


import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Component
@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]X")
    private Date date;
    String logLevel;
    String method;
    String path;
    String requestData;

    public Log(HttpServletRequest request) {
        this.date = new Date();
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
        this.method = request.getMethod();
        this.path = request.getRequestURI();
        this.requestData = request.getQueryString();
    }

    @Override
    public String toString() {
        if (requestData == null) {
            return date+ " " + logLevel + " " + path + " " + method + "\n";
        } else {
            return date + " " + logLevel + " " + path + " " + method + " " + requestData + "\n";
        }
    }
}