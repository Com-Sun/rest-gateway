package com.nhnacademy.gateway.adapter;

import com.nhnacademy.gateway.domain.dto.account.request.AccountLoginRequestDTO;
import com.nhnacademy.gateway.domain.dto.account.request.AccountRegisterRequestDTO;
import com.nhnacademy.gateway.domain.dto.account.response.AccountResponseDTO;

public interface AccountAdapter {
    AccountResponseDTO loginAccount(AccountLoginRequestDTO requestDTO);

    AccountResponseDTO registerAccount(AccountRegisterRequestDTO requestDTO);
}
