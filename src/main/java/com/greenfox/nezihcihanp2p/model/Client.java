package com.greenfox.nezihcihanp2p.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    String id;

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                '}';
    }
}
