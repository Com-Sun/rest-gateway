package com.nhnacademy.gateway.domain.dto.account.response;

import lombok.Getter;

@Getter
public class AccountResponseDTO {
    private Long accountNum;
    private String accountId;
    private String accountPwd;
    private String accountMail;
    private String accountStatus;
    @Override
    public String toString() {
        return "AccountResponseDTO{" +
            "accountNum=" + accountNum +
            ", accountId='" + accountId + '\'' +
            ", accountPwd='" + accountPwd + '\'' +
            ", accountMail='" + accountMail + '\'' +
            ", accountStatus='" + accountStatus + '\'' +
            '}';
    }
}
