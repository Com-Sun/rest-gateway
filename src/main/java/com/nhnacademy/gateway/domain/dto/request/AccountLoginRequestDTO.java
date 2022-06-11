package com.nhnacademy.gateway.domain.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AccountLoginRequestDTO {
    @NotBlank(message = "아이디가 공백으로 인한 에러")
    private String accountId;

}
