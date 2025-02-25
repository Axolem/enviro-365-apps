package com.enviro.assessment.inter001.axolemaranjana.errors;

import lombok.Getter;

//inner class example
@Getter
public class ErrorResponse {
    // Getters and setters...
    private final String errorCode;
    private final String message;
    private final int status;

    public ErrorResponse(String errorCode, String message, int status) {
        this.errorCode = errorCode;
        this.message = message;
        this.status = status;
    }

}
