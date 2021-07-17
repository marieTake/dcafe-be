package com.dcafe.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public boolean login(String shopuserid, String password) {
		UserDetails userDetails;
		
		try{
			userDetails = userDetailsService.loadUserByUsername(shopuserid);
		}catch(UsernameNotFoundException e) {
			return false;
		}
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password,
				userDetails.getAuthorities());
		try{
			authenticationManager.authenticate(token);
		}catch(AuthenticationException ae) {
			return false;
		}
		boolean result = token.isAuthenticated();
		if (result) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		return result;
	}
}