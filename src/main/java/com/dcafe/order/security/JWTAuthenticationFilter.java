package com.dcafe.order.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.dcafe.order.entities.Shopuser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private static final String SECRET = "466b1f536226446cb51e53e27baf9d93";
	
	// トークンの有効期間(1時間)
    private static final long EXPIRATION_TIME = 1000L * 60L * 60L;

    @Autowired
	private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/shopuser/login"); 
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) 
    		throws AuthenticationException {
        try {
            Shopuser creds = new ObjectMapper().readValue(req.getInputStream(), Shopuser.class);
            return authenticationManager.authenticate(
            		new UsernamePasswordAuthenticationToken(
            				creds.getShopUserId(),
            				creds.getPassword(),
            				creds.getRoles()
            				)
            		);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException {
        String token = JWT
        		.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(com.auth0.jwt.algorithms.Algorithm.HMAC512(SECRET.getBytes()));
        
        String body = ((User) auth.getPrincipal()).getUsername() + " " + token;

        res.getWriter().write(body);
        res.getWriter().flush();
    }
}