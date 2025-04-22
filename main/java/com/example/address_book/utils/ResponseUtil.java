package com.example.address_book.utils;

import com.example.address_book.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalTime;

public class ResponseUtil {

    public static ResponseEntity<Response> generateResponse(String status, String message, Object data, HttpStatus statusCode) {
        Response response = new Response(status, message, data, LocalTime.now());
        return new ResponseEntity<>(response, statusCode);
    }

    public static ResponseEntity<Response> successResponse(String message, Object data) {
        return generateResponse("success", message, data, HttpStatus.OK);
    }

    public static ResponseEntity<Response> errorResponse(String message, Object data, HttpStatus statusCode) {
        return generateResponse("error", message, data, statusCode);
    }
}
