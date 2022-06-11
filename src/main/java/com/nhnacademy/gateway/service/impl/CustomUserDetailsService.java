package com.nhnacademy.gateway.service.impl;

import com.nhnacademy.gateway.domain.SecurityUser;
import com.nhnacademy.gateway.domain.dto.request.AccountLoginRequestDTO;
import com.nhnacademy.gateway.domain.dto.response.AccountResponseDTO;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8090";


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // loginRequest를 id만 사용. 그리고 response랑 비교는 security가 알아서.
        AccountLoginRequestDTO requestDTO = new AccountLoginRequestDTO(username);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AccountLoginRequestDTO> httpEntity = new HttpEntity<>(requestDTO, headers);
        ResponseEntity<AccountResponseDTO>
            response = restTemplate.exchange(BASE_URL + "/accounts/login",
            HttpMethod.POST,
            httpEntity,
            new ParameterizedTypeReference<AccountResponseDTO>(){});

        AccountResponseDTO responseDTO = response.getBody();

        return new SecurityUser(responseDTO.getAccountId(), responseDTO.getAccountPwd(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")),
            responseDTO.getAccountMail());
    }
}
