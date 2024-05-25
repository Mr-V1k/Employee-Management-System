package dev.v1k.Employee.Management.System.exceptions;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorObject {
    private HttpStatus statusCode;
    private String message;
    private Date timestamp;

    public ErrorObject() {
    }

    public ErrorObject(HttpStatus statusCode, String message, Date timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
