package com.nhnacademy.gateway.adapter.impl;

import com.nhnacademy.gateway.adapter.AccountAdapter;
import com.nhnacademy.gateway.domain.dto.request.AccountLoginRequestDTO;
import com.nhnacademy.gateway.domain.dto.response.AccountResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
@Slf4j
public class AccountAdapterImpl implements AccountAdapter {

    private static final String BASE_URL = "http://localhost:8090";
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AccountResponseDTO loginAccount(AccountLoginRequestDTO requestDTO) {
        requestDTO.setAccountPwd(passwordEncoder.encode(requestDTO.getAccountPwd()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AccountLoginRequestDTO> httpEntity = new HttpEntity<>(requestDTO, headers);
        ResponseEntity<AccountResponseDTO>
            response = restTemplate.exchange(BASE_URL + "/accounts/login",
            HttpMethod.POST,
            httpEntity,
            new ParameterizedTypeReference<AccountResponseDTO>(){});

        log.info("나와ㅏ라~~~~~~~~~~~~~~~ = {}", response.getBody());
        return response.getBody();
    }
}
