package com.vroomcar.JPADemo.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class CustomErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    
    private String error;
   // HttpStatus status;
//    CustomErrorResponse(HttpStatus status, Throwable ex) {
//       
//        this.status = status;
//        this.message = "Unexpected error";
//        this.debugMessage = ex.getLocalizedMessage();
//    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}