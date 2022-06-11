package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.domain.dto.request.AccountRegisterRequestDTO;

public interface AccountService {
    void registerAccountRequest(AccountRegisterRequestDTO requestDTO);
}
