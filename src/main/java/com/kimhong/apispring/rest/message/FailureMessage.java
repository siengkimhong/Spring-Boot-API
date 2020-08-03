package com.kimhong.apispring.rest.message;

public enum FailureMessage {

    NOT_FOUND_BY_ID("The record with this id doesn't exist"),
    CATEGORY_NAME_CANNOT_BE_EMPTY("Category name couldn't be emptied");
    private final String message;

    FailureMessage(String message) {
        this.message = message;
    }

    public String value() {
        return message;
    }
}
