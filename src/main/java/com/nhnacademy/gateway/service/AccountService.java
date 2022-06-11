package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.domain.dto.request.AccountLoginRequestDTO;
import com.nhnacademy.gateway.domain.dto.request.AccountRegisterRequestDTO;
import com.nhnacademy.gateway.domain.dto.response.AccountResponseDTO;

public interface AccountService {
    AccountResponseDTO registerAccountRequest(AccountRegisterRequestDTO requestDTO);
    AccountResponseDTO loginAccountRequest(AccountLoginRequestDTO requestDTO);
}
