package com.greenfox.nezihcihanp2p.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

//  Timestamp date = new Timestamp(System.currentTimeMillis());  //import java.sql.Timestamp;

//  @Temporal(TemporalType.TIMESTAMP)
//  private Date dateCreated;  //import java.util.Date;

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
    }

    public Log(HttpServletRequest request, String requestData) {
        this.date = new Date();
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
        this.method = request.getMethod();
        this.path = request.getRequestURI();
        this.requestData = requestData;

        if (requestData == null) {
            System.out.println(this.date + " " + this.logLevel + " " + this.method + " " + this.path);
        } else {
            System.out.println(this.date + " " + this.logLevel + " " + this.method + " " + this.path + " " + this.requestData);
        }
    }

    public void printLog() {
        if (requestData == null) {
            System.out.println(this.date + " " + this.logLevel + " " + this.method + " " + this.path);
        } else {
            System.out.println(this.date + " " + this.logLevel + " " + this.method + " " + this.path + " " + this.requestData);
        }
    }

}