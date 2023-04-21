package com.learn.timezone.exception;

public class ErrorMessage {

    private String message;
    private Long errorId;

    public ErrorMessage(String message, Long errorId) {
        this.message = message;
        this.errorId = errorId;
    }

    public String getMessage() {
        return message;
    }

    public Long getErrorId() {
        return errorId;
    }
}
