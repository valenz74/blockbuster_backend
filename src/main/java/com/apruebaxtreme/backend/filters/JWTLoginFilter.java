package com.apruebaxtreme.backend.filters;

import java.io.IOException;
import java.lang.reflect.Array;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.apruebaxtreme.backend.dto.JwtDTO;
import com.apruebaxtreme.backend.dto.UsernamePasswordDTO;
import com.apruebaxtreme.backend.util.JwtUtils;
import com.apruebaxtreme.backend.util.ResponseError;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTLoginFilter extends OncePerRequestFilter {

    @Autowired
    AuthenticationManager authenticationManager;

    private UsernamePasswordDTO usernamePasswordDTO(HttpServletRequest request) {

        try {
            byte[] inputStreamBytes = StreamUtils.copyToByteArray(request.getInputStream());
            UsernamePasswordDTO usernamePasswordDTO = new ObjectMapper().readValue(inputStreamBytes,
                    UsernamePasswordDTO.class);
            return usernamePasswordDTO;
        } catch (Exception e) {
            // TODO: handle exception
            return new UsernamePasswordDTO(null, null);
        }

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String method = request.getMethod();
        String uri = request.getRequestURI();// /login

        if (method.equals("POST") && uri.equals("/login")) {
            UsernamePasswordDTO usernamePasswordDTO = usernamePasswordDTO(request);

            String username = usernamePasswordDTO.getUsername();
            String password = usernamePasswordDTO.getPassword();
            if (username != null && password != null) {

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, password);

                try {
                    Authentication authenticated = authenticationManager.authenticate(auth);

                    GrantedAuthority authority = (GrantedAuthority) authenticated.getAuthorities().toArray()[0];

                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getWriter(),
                            new JwtDTO(JwtUtils.crearJwtToken(username, authority.getAuthority())));
                } catch (Exception e) {
                    ResponseError.responseError(response, "bad credentials");

                }

            } else {
                ResponseError.responseError(response, "null credentials");
            }
        } else {
            filterChain.doFilter(request, response);
        }

    }

}
