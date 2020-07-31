package com.kimhong.apispring.rest.message;

public enum FailureMessage {

    NOT_FOUND_BY_ID("The record with this id doesn't exisit");
    private final String message;

    FailureMessage(String message) {
        this.message = message;
    }

    public String value() {
        return message;
    }
}
