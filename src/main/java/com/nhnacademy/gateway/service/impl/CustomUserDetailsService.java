package com.nhnacademy.gateway.service.impl;

import com.nhnacademy.gateway.adapter.AccountAdapter;
import com.nhnacademy.gateway.domain.SecurityUser;
import com.nhnacademy.gateway.domain.dto.account.request.AccountLoginRequestDTO;
import com.nhnacademy.gateway.domain.dto.account.response.AccountResponseDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
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

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountAdapter accountAdapter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        AccountResponseDTO response = accountAdapter.loginAccount(new AccountLoginRequestDTO(username, ""));
        SecurityUser securityUser = new SecurityUser(response.getAccountId(),
            response.getAccountPwd(), authorities, response.getAccountMail());

        Authentication
            authentication = new UsernamePasswordAuthenticationToken(securityUser, securityUser.getPassword(), authorities);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
        return securityUser;
    }

}
