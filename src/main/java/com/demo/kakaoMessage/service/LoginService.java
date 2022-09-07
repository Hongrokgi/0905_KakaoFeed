package com.demo.kakaoMessage.service;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
@Slf4j
public class LoginService extends HttpCallService{
    private static final String LOGIN_URL = "https://kauth.kakao.com/oauth/authroize";

    public String getLogin() {
        String code = "";
        String state = "";
        String error = "";
        String error_description = "";
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("client_id","9fe97b094255a1ba147d10cc045a5bf6");
        parameters.add("redirect_url","http://localhost:88");
        parameters.add("response_type","code");
        parameters.add("scope","talk_message");

        HttpEntity<?> requestEntity = httpClientEntity(parameters);

        ResponseEntity<String> response = httpRequest(LOGIN_URL, HttpMethod.GET, requestEntity);
        JSONObject jsonData = new JSONObject(response.getBody());
        return null;
    }
}
