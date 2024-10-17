package com.jaehyeong.cloudcomputing_1.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @NotBlank(message = "이메일은 비울 수 없습니다.")
    @Email(message = "유효한 이메일 주소를 입력하세요.")
    private String email;

    @NotBlank(message = "비밀번호는 비울 수 없습니다.")
    private String password;

    public @NotBlank(message = "비밀번호는 비울 수 없습니다.") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "비밀번호는 비울 수 없습니다.") String password) {
        this.password = password;
    }

    public @NotBlank(message = "이메일은 비울 수 없습니다.") @Email(message = "유효한 이메일 주소를 입력하세요.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "이메일은 비울 수 없습니다.") @Email(message = "유효한 이메일 주소를 입력하세요.") String email) {
        this.email = email;
    }
}
