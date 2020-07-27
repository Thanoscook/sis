package com.example.demo;

public class CustomResponse {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomResponse(String type, String message) {
        this.type = type;
        this.message = message;
    }

    String type;
    String message;

    @Override
    public String toString() {
        return "TYPE: " + getType() + ", MESSAGE: " + message;
    }
}
