package com.apruebaxtreme.backend.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.apruebaxtreme.backend.util.JwtUtils;
import com.apruebaxtreme.backend.util.ResponseError;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTValidateFilter extends OncePerRequestFilter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //header Authorization: Bearer e546gbkj...
        String headerAuth = request.getHeader("Authorization");
        
        if(headerAuth!=null){
            String jwt = headerAuth.substring(7);

            if(JwtUtils.tokenValido(jwt)){
                UserDetails userDetails = userDetailsService.loadUserByUsername(JwtUtils.username(jwt));

                UsernamePasswordAuthenticationToken authenticated =
                new UsernamePasswordAuthenticationToken(userDetails.getUsername(),null, userDetails.getAuthorities());
                
                SecurityContextHolder.getContext().setAuthentication(authenticated);
                filterChain.doFilter(request, response);
            }else{
                ResponseError.responseError(response, "jwt incorrecto");
            }
        }else{
            filterChain.doFilter(request, response);
        }
    }
    
}
