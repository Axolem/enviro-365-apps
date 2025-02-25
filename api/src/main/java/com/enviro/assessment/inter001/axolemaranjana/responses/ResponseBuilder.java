package com.enviro.assessment.inter001.axolemaranjana.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseBuilder {
    public ResponseEntity<Map<String, Object>> buildResponse(String message, Object data, String details, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("data", data);
        response.put("details", details);
        return new ResponseEntity<>(response, status);
    }

    public ResponseEntity<Map<String, Object>> buildSuccessResponse(String message, Object items, int count, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);

        Map<String, Object> data = new HashMap<>();
        data.put("items", items);
        data.put("count", count);

        response.put("data", data);
        response.put("details", null);

        return new ResponseEntity<>(response, status);
    }

    public ResponseEntity<Map<String, Object>> buildErrorResponse(String message, String details, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("data", new HashMap<>()); // or new ArrayList<>() if items should be an array.
        response.put("details", details);
        return new ResponseEntity<>(response, status);
    }

    //Overloaded method for error responses without details.
    public ResponseEntity<Map<String, Object>> buildErrorResponse(String message, HttpStatus status) {
        return buildErrorResponse(message, null, status);
    }
}
