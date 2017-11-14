package com.greenfox.nezihcihanp2p.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


import javax.persistence.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
//    private Message message;

    private String username;

    public User(String username) {
        this.username = username;
    }
}
