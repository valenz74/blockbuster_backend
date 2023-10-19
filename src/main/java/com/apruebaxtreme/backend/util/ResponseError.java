package com.apruebaxtreme.backend.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;

public class ResponseError {

    public static void responseError(HttpServletResponse response, String mensaje) throws StreamWriteException, DatabindException, IOException{

        Map <String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", mensaje);

        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        new ObjectMapper().writeValue(response.getWriter(), errorDetails);
    }
    
}
