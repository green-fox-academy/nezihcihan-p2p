package com.greenfox.nezihcihanp2p.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReceivedMessage {

    Message message;
    Client client;

    public ReceivedMessage(Message message, Client client) {
        this.message = message;
        this.client = client;
    }

    @Override
    public String toString() {
        return "{" +
                "message=" + message +
                ", client=" + client +
                '}';
    }
}
