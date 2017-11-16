package com.greenfox.nezihcihanp2p.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    private long id;
    private String username;
    private String text;
    private Timestamp timestamp;

    public Message(String text) {
        this.text = text;
        this.id = 1000000L + (long) (Math.random() * (9999999L - 1000000L));
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Message(long id, String username, String text, Timestamp timestamp) {
        this.id = id;
        this.username = username;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Message() {
    }

    public Message(String username, String text, Timestamp timestamp) {
        this.username = username;
        this.text = text;
        this.timestamp = timestamp;
    }
}
