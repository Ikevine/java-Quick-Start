package com.kevine.security.config;

import com.kevine.security.view.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {

        final String jwt;
        final String userEmail;
//        to see if the user have the token

        //extraction of the header
        final String authHeader = request.getHeader("Authorization");
        //check and send the response
        if(authHeader == null || !authHeader.startsWith("bearer")) {
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7);
        //is used to extract the email the jwt token we use the class above
       userEmail = jwtService.extractUserName(jwt);
       //if user is already authenticated we don't need to put other
       if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
           //check if we have user into our database
           UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
       }

    }
}
