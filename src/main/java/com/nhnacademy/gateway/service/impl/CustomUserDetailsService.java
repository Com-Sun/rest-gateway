package com.nhnacademy.gateway.service.impl;

import com.nhnacademy.gateway.domain.SecurityUser;
import com.nhnacademy.gateway.domain.dto.request.AccountLoginRequestDTO;
import com.nhnacademy.gateway.domain.dto.response.AccountResponseDTO;
import com.nhnacademy.gateway.service.AccountService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        AccountResponseDTO response = accountService.loginAccountRequest(new AccountLoginRequestDTO(username, ""));
        SecurityUser securityUser = new SecurityUser(response.getAccountId(),
            response.getAccountPwd(), authorities, response.getAccountMail());

        Authentication
            authentication = new UsernamePasswordAuthenticationToken(securityUser, "USER_PASSWORD", authorities);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
        return securityUser;
    }
}
