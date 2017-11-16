package com.greenfox.nezihcihanp2p.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.greenfox.nezihcihanp2p.model.Message;
import com.greenfox.nezihcihanp2p.model.ReceivedMessage;
import com.greenfox.nezihcihanp2p.model.Response;
import com.greenfox.nezihcihanp2p.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
public class RestController {

    @Autowired
    MessageRepository messageRepository;

    @CrossOrigin("*")
    @PostMapping("/api/message/receive")
    public Response receive(@RequestBody ReceivedMessage receivedMessage) {
        System.out.println(receivedMessage.getClient().getId());

        RestTemplate restTemplate = new RestTemplate();

        if (!receivedMessage.getClient().getId().equals(System.getenv("CHAT_APP_UNIQUE_ID"))) {
            try {
                restTemplate
                        .postForObject(System.getenv("CHAT_APP_PEER_ADDRESS"), receivedMessage, Response.class);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        Message received = new Message();
        List<String> errors = new ArrayList<>();
        Response response = new Response();

        if (StringUtils.isEmpty(receivedMessage.getMessage().getText())) {
            errors.add("message.text");
        } else {
            received.setText(receivedMessage.getMessage().getText());
        }

        if (StringUtils.isEmpty(receivedMessage.getMessage().getUsername())) {
            errors.add("message.username");
        } else {
            received.setUsername(receivedMessage.getMessage().getUsername());
        }

        if (StringUtils.isEmpty(receivedMessage.getMessage().getTimestamp())) {
            errors.add("message.timestamp");
        } else {
            received.setTimestamp(receivedMessage.getMessage().getTimestamp());
        }

        if (StringUtils.isEmpty(receivedMessage.getMessage().getId())) {
            errors.add("message.id");
        } else {
            received.setId(receivedMessage.getMessage().getId());
        }

        if (StringUtils.isEmpty(receivedMessage.getClient().getId())) {
            errors.add("client.id");
        }
        if (errors.size() == 0) {
            response.setStatus("ok");
            messageRepository.save(received);
        } else {
            response.setStatus("error");
            response.setErrorMessage(errors);
        }
        return response;
    }
}