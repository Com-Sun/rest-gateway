package com.nhnacademy.gateway.adapter;

import com.nhnacademy.gateway.domain.dto.request.AccountLoginRequestDTO;
import com.nhnacademy.gateway.domain.dto.response.AccountResponseDTO;

public interface AccountAdapter {
    AccountResponseDTO loginAccount(AccountLoginRequestDTO requestDTO);
}
