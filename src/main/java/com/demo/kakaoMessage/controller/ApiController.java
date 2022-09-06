package com.demo.kakaoMessage.controller;

import com.demo.kakaoMessage.domain.domain.Body774DTO;
import com.demo.kakaoMessage.domain.entity.Body774;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Slf4j
@RestController
public class ApiController {
    @PostMapping("/push")
    public ResponseEntity<Void> PushData(MultipartHttpServletRequest request) throws Exception {
        log.info("===== Data Push =====");
        String json = request.getParameter("json");
        JsonNode parent = new ObjectMapper().readTree(json);
        JsonNode msg_id = parent.findValue("msg_id");
        JsonNode data = parent.findValue("data");
        ObjectMapper objectMapper = new ObjectMapper();
        int msgId = msg_id.asInt();
        switch (msgId) {
            case 774:
                JsonNode body_attr = data.findValue("body_attr");
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                if (body_attr.size() == 0) {
                    log.info("No body_attr");
                } else {
                    log.info("body_attr.size() : " + body_attr.size());
                    Body774DTO body774DTO = objectMapper.treeToValue(data, Body774DTO.class);
                    String eventsType = body774DTO.getEventsType();
                    if(eventsType.isEmpty()) {
                        log.info("useless Alarm");
                    }else if(eventsType.equals("390")) {
                        log.info("390 Alarm");
                        Body774 body774 = body774DTO.toEntity(body774DTO.getCameraName(), body774DTO.getChannel(), body774DTO.getDeviceId(), body774DTO.getEventsType(), body774DTO.getSnapId(), body774DTO.getSnapPath(), body774DTO.getTrigger());
                        System.out.println("body774 = " + body774);
                    }else if(eventsType.equals("394")) {
                        log.info("394 Alarm");
                        Body774 body774 = body774DTO.toEntity(body774DTO.getCameraName(), body774DTO.getChannel(), body774DTO.getDeviceId(), body774DTO.getEventsType(), body774DTO.getSnapId(), body774DTO.getSnapPath(), body774DTO.getTrigger());
                        System.out.println("body774 = " + body774);
                    }else if(eventsType.equals("389")) {
                        log.info("389 Alarm");
                        Body774 body774 = body774DTO.toEntity(body774DTO.getCameraName(), body774DTO.getChannel(), body774DTO.getDeviceId(), body774DTO.getEventsType(), body774DTO.getSnapId(), body774DTO.getSnapPath(), body774DTO.getTrigger());
                        System.out.println("body774 = " + body774);
                    }
                }

                break;
            case 775:
                log.info("This is Heartbeat Alarm");
                break;
        }

//`case1 : events_type ="394" -> length 5개 , msg_id 774 case2 : events_type = "" -> length 2개, msg_id=774 case3: events_type = null -> length 4개 , msg_id= 775

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
