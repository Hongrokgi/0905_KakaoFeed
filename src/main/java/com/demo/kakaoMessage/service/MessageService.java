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
public class MessageService extends HttpCallService{
    private static final String MSG_SEND_SERVICE_URL = "https://kapi.kakao.com/v2/api/talk/memo/send";
    private static final String SEND_SUCCESS_MSG = "메시지 전송에 성공했습니다.";
    private static final String SEND_FAIL_MSG = "메시지 전송에 실패했습니다.";
    private static final String SUCCESS_CODE = "0"; // Kakao api 에서 return 하는 success_code 값.
    public boolean sendMessage(String accessToken) {
        // 사용자 정의 템플릿은 template_id만
//        JSONObject templateObj = new JSONObject();
//        templateObj.put("template_id","82472");

        HttpHeaders header = new HttpHeaders();
        header.set("Content-Type",APP_TYPE_URL_ENCODED);
        header.set("Authorization", "Bearer "+accessToken); // 두 개는 괜찮음  두 개에 template id만 담아서 httpCall

        JSONObject argsObj = new JSONObject();
//        argsObj.put("THU","https://ifh.cc/g/APBkvM.jpg");
        argsObj.put("THU","http://211.111.12.130:9090/img/6a5f08164b3546fe96a15b65ae50019f.ab2c20ce.png");

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("template_id", "82493");
        parameters.add("template_args",argsObj.toString());



        HttpEntity<?> messageRequestEntity = httpClientEntity(header, parameters);
        String resultCode = "";
        ResponseEntity<String> response = httpRequest(MSG_SEND_SERVICE_URL, HttpMethod.POST, messageRequestEntity); // 33번 해당 메서드에서 오류발생 추정
        JSONObject jsonData = new JSONObject(response.getBody());
        resultCode = jsonData.get("result_code").toString();

        return successCheck(resultCode);
    }

    public boolean successCheck(String resultCode) {
        if(resultCode.equals(SUCCESS_CODE)) {
            log.info(SEND_SUCCESS_MSG);
            return true;
        }else {
            log.info(SEND_FAIL_MSG);
            return false;
        }
    }
}
