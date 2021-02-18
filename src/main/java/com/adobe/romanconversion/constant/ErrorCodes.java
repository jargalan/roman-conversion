package com.adobe.romanconversion.constant;

public enum ErrorCodes {
    INTERNAL_SERVER_ERROR("A1200"),
    BAD_REQUEST_ILLEGAL_ARGUMENT("A1400");

    private final String value;

    ErrorCodes(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
