package com.nhnacademy.gateway.domain.dto.account.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
//TODO 이거 Builder 지우기 테스
public class AccountRegisterRequestDTO {
    @NotBlank(message = "아이디가 공백으로 인한 에러")
    private String accountId;

    @NotBlank(message = "비밀번호가 공백으로 인한 에러")
    private String accountPwd;

    @NotBlank(message = "메일이 공백으로 인한 에러")
    @Email(message = "유효하지 않은 메일로 인한 에러")
    private String accountMail;
}
