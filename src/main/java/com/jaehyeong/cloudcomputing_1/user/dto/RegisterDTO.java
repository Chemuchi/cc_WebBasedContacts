package com.jaehyeong.cloudcomputing_1.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterDTO {

    @NotBlank(message = "이름은 필수 입력 사항입니다.")
    private String name;

    @NotBlank(message = "이메일은 필수 입력 사항입니다.")
    @Email(message = "유효한 이메일 주소를 입력하세요")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
    private String password;

    public @NotBlank(message = "이름은 필수 입력 사항입니다.") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "이름은 필수 입력 사항입니다.") String name) {
        this.name = name;
    }

    public @NotBlank(message = "이메일은 필수 입력 사항입니다.") @Email(message = "유효한 이메일 주소를 입력하세요") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "이메일은 필수 입력 사항입니다.") @Email(message = "유효한 이메일 주소를 입력하세요") String email) {
        this.email = email;
    }

    public @NotBlank(message = "비밀번호는 필수 입력 사항입니다.") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "비밀번호는 필수 입력 사항입니다.") String password) {
        this.password = password;
    }
}
