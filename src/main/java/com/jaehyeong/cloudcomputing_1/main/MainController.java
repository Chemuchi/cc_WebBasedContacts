package com.jaehyeong.cloudcomputing_1.main;

import com.jaehyeong.cloudcomputing_1.user.model.UserEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    /*private static final Logger logger = LoggerFactory.getLogger(MainController.class);


    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @GetMapping("/")
    public String mainPage(HttpSession session){
        UserEntity user = (UserEntity) session.getAttribute("user");
        if(user == null){
            logger.info("세션 없음 혹은 만료");
            return "redirect:/login";
        } else {
            logger.info("세션 유지중, 사용자: " + user.getEmail());
            return "mainpage";
        }
    }*/
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/")
    public String mainPage(HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
            logger.info("세션 없음 혹은 만료");
            return "redirect:/login";
        } else {
            logger.info("세션 유지중, 사용자: " + user.getEmail());
            return "mainpage";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/login";
    }
}

