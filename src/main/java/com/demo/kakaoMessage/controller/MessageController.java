package com.demo.kakaoMessage.controller;

import com.demo.kakaoMessage.service.AuthService;
import com.demo.kakaoMessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    AuthService authService;

    @Autowired
    MessageService messageService;


    @GetMapping("/")
    public String serviceStart(String code) {
       if(authService.getKakaoAuthToken(code)) {
            messageService.sendMessage(AuthService.authToken);
            return "메시지 전송 성공";
       }else {
           return "토큰 발급 실패";
       }
     }
}
