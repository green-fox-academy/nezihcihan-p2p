package com.greenfox.nezihcihanp2p.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class Message {

    @Id
    private long id;
    private String username;
    private String text;
    private Timestamp timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_user_id")
    User user;

    public Message(String message) {
        this.text = message;
        this.id = 1000000L + (long) (Math.random() * (9999999L - 1000000L));
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", message='" + text + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
