package com.greenfox.nezihcihanp2p.model;

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
@Component
//@Table(name = "messages")
public class Message {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;

    private long id;
    private String username;
    private String message;
    private Timestamp timestamp;

//    @OneToOne(mappedBy = "message",cascade = CascadeType.ALL)
//    private User user;
    public Message(String message) {
        this.message = message;
        this.id = 1000000L + (long) (Math.random() * (9999999L - 1000000L));
    }
}
