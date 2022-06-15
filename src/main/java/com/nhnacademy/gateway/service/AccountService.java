package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.domain.dto.account.request.AccountLoginRequestDTO;
import com.nhnacademy.gateway.domain.dto.account.request.AccountRegisterRequestDTO;
import com.nhnacademy.gateway.domain.dto.account.response.AccountResponseDTO;

public interface AccountService {
    AccountResponseDTO registerAccountRequest(AccountRegisterRequestDTO requestDTO);
    AccountResponseDTO loginAccountRequest(AccountLoginRequestDTO requestDTO);
}
