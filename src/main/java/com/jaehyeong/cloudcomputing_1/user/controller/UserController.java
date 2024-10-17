package com.jaehyeong.cloudcomputing_1.user.controller;

import com.jaehyeong.cloudcomputing_1.user.dto.LoginDTO;
import com.jaehyeong.cloudcomputing_1.user.dto.RegisterDTO;
import com.jaehyeong.cloudcomputing_1.user.model.UserEntity;
import com.jaehyeong.cloudcomputing_1.user.service.UserService;
import com.jaehyeong.cloudcomputing_1.user.service.UserServiceImpl;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@Valid @RequestBody RegisterDTO registerDTO){
        try {
            UserEntity userEntity = userService.registerUser(registerDTO);
            return ResponseEntity.ok(userEntity);
        }catch (Exception e){
            logger.error("회원가입 실패", e);
            return null;
        }

    }

    /*@PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO, HttpSession httpSession){
        UserEntity user = userService.loginUser(loginDTO);
        if (user != null) {
         httpSession.setAttribute("user", user);
         logger.info("세션 생성: "+ httpSession.getId());
         return ResponseEntity.ok("로그인이 성공적으로 완료되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("이메일 또는 비밀번호가 잘못되었습니다.");
        }
    }*/

    @PostMapping("/test/login")
    public ResponseEntity<String> testLogin(){
        return ResponseEntity.ok("전달완료");
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO, HttpSession httpSession) {
        logger.info("로그인 요청 수신 - 이메일: {}", loginDTO.getEmail());

        UserEntity user = userService.loginUser(loginDTO);
        if (user != null) {
            httpSession.setAttribute("user", user);
            logger.info("로그인 성공 - 세션 생성: {}", httpSession.getId());
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "/")
                    .build();
        } else {
            logger.warn("로그인 실패 - 잘못된 이메일 또는 비밀번호");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("이메일 또는 비밀번호가 잘못되었습니다.");
        }
    }

    /*@PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
        return "redirect:/login";
    }*/


}
