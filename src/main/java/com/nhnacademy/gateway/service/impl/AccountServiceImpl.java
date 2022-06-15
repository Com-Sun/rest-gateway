package com.nhnacademy.gateway.service.impl;

import com.nhnacademy.gateway.adapter.AccountAdapter;
import com.nhnacademy.gateway.domain.dto.account.request.AccountLoginRequestDTO;
import com.nhnacademy.gateway.domain.dto.account.request.AccountRegisterRequestDTO;
import com.nhnacademy.gateway.domain.dto.account.response.AccountResponseDTO;
import com.nhnacademy.gateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountAdapter accountAdapter;
    @Override
    public AccountResponseDTO registerAccountRequest(AccountRegisterRequestDTO requestDTO) {
        return accountAdapter.registerAccount(requestDTO);
    }

    public AccountResponseDTO loginAccountRequest(AccountLoginRequestDTO requestDTO) {
        return accountAdapter.loginAccount(requestDTO);
    }

}
