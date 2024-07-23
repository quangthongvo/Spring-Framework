package com.vti.blog_app.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;



public class Error {
    private String timestamp;
    private String message;
    private Map<String, String> errors;

    public Error( String message, Map<String, String> errors) {
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
        this.errors = errors;
    }
}
