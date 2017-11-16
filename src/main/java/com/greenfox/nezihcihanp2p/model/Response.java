package com.greenfox.nezihcihanp2p.model;

import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import java.util.List;
public class Response {

    String status;
    String error;

    public Response() {
    }

    public Response(String status, String error) {
        this.status = status;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setErrorMessage(List<String> errorMessage) {
        this.status = "Missing field(s): ";
        for (String entry : errorMessage) {
            this.status += entry + ", ";
        }
        this.status = this.status.substring(0, this.status.length() - 2);
    }

}
