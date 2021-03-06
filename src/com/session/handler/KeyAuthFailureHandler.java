package com.session.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class KeyAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		setDefaultFailureUrl("/login.jsp?status=" + exception.getMessage());
		System.out.println("Exceptions while login:   "+ exception.getMessage());
		super.onAuthenticationFailure(request, response, exception);
	}
}
