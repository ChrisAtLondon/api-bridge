package com.chris.apibridge.security;

import com.google.common.net.HttpHeaders;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

public class BridgeAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    public BridgeAuthenticationProcessingFilter() {
        super(new AntPathRequestMatcher("/**", "POST",false));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {

//        String traffic = httpServletRequest.getParameter("traffic");
//        String headerAuth = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
//        List<GrantedAuthority> authorities = new LinkedList<>();
//        authorities.add(new SimpleGrantedAuthority("anybody"));
//        Authentication authToken = new AnonymousAuthenticationToken("anyClient","anybody",authorities);
//        ((AnonymousAuthenticationToken) authToken).setDetails(headerAuth);
//        System.out.println(headerAuth);
//        return this.getAuthenticationManager().authenticate(authToken);
        return null;
    }
}
