package com.jaehyeong.cloudcomputing_1.user.service;

import com.jaehyeong.cloudcomputing_1.exception.LoginFailedException;
import com.jaehyeong.cloudcomputing_1.user.dto.LoginDTO;
import com.jaehyeong.cloudcomputing_1.user.dto.RegisterDTO;
import com.jaehyeong.cloudcomputing_1.exception.UserAlreadyExistsException;
import com.jaehyeong.cloudcomputing_1.user.model.UserEntity;
import com.jaehyeong.cloudcomputing_1.user.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserEntity registerUser(RegisterDTO registerDTO) {

        if (userRepository.findByEmail(registerDTO.getEmail()) != null) {
            throw new UserAlreadyExistsException("중복된 이메일");
        }

        String encodedPassword = passwordEncoder.encode(registerDTO.getPassword());

        UserEntity userEntity = UserEntity.builder()
                .email(registerDTO.getEmail())
                .password(encodedPassword)
                .name(registerDTO.getName())
                .build();
        return userRepository.save(userEntity);

    }
    public UserEntity loginUser(LoginDTO loginDTO){
        UserEntity user = userRepository.findByEmail(loginDTO.getEmail());

        if(user != null && passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())){
            return user;
        } else {
            return null;
        }

    }
}
