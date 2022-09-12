package com.gwabs.spring_example.user;

import java.net.URI;

public class message {
    private int status;
    private String msg;
    private URI location;

    public message(int status, String msg,URI location) {
        this.status = status;
        this.msg = msg;
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public URI getLocation() {
        return location;
    }

    public void setLocation(URI location) {
        this.location = location;
    }
}
