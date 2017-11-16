package com.greenfox.nezihcihanp2p.model;


public class ReceivedMessage {

    Message message;
    Client client;

    public ReceivedMessage(Message message, Client client) {
        this.message = message;
        this.client = client;
    }

    public ReceivedMessage() {
    }

    public Message getMessage() {
        return message;
    }

    public Client getClient() {
        return client;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
