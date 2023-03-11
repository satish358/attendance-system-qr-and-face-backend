package com.satishmankar.attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class BasicDTO<T> {
    private boolean isSuccess;
    private String message;
    private T data;

    public BasicDTO(String message, T data) {
        this.message = message;
        this.data = data;
        setSuccess(true);
    }

    public BasicDTO(T data) {
        this.data = data;
        setSuccess(true);
        setMessage("Success");
    }

    public BasicDTO(String message) {
        this.message = message;
        setSuccess(false);
    }
}
