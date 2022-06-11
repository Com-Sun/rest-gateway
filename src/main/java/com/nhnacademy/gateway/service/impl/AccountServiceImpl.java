package com.nhnacademy.gateway.service.impl;

import com.nhnacademy.gateway.domain.dto.request.AccountRegisterRequestDTO;
import com.nhnacademy.gateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private static final String BASE_URL = "http://localhost:8090";
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerAccountRequest(AccountRegisterRequestDTO requestDTO) {
        requestDTO.setAccountPwd(passwordEncoder.encode(requestDTO.getAccountPwd()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AccountRegisterRequestDTO> httpEntity = new HttpEntity<>(requestDTO, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL + "/accounts", HttpMethod.POST, httpEntity, String.class);

        log.info("나와라~~~~~~~~~~~~~~ = {}" + response.getBody());
    }
}