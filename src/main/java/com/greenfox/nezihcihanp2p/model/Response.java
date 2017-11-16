package com.greenfox.nezihcihanp2p.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    String status;
    String error;



    public void setErrorMessage(List<String> errorMessage) {
        this.status = "Missing field(s): ";
        for (String entry : errorMessage) {
            this.status += entry + ", ";
        }
        this.status = this.status.substring(0, this.status.length() - 2);
    }

}