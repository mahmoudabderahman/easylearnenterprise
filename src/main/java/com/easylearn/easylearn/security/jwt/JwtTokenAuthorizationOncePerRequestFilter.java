package com.easylearn.easylearn.security.jwt;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenAuthorizationOncePerRequestFilter extends OncePerRequestFilter {
}
