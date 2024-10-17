package com.jaehyeong.cloudcomputing_1.user.service;

import com.jaehyeong.cloudcomputing_1.user.dto.LoginDTO;
import com.jaehyeong.cloudcomputing_1.user.dto.RegisterDTO;
import com.jaehyeong.cloudcomputing_1.user.model.UserEntity;

public interface UserService {
    UserEntity registerUser(RegisterDTO registerDTO);
    UserEntity loginUser(LoginDTO loginDTO);
}
