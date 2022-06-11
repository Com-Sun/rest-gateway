package com.nhnacademy.gateway.domain.dto.response;

import lombok.Getter;

@Getter
public class AccountResponseDTO {
    private Long accountNum;
    private String accountId;
    private String accountPwd;
    private String accountMail;
    private String accountStatus;
}
