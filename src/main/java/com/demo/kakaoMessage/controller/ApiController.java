package com.demo.kakaoMessage.controller;

import com.demo.kakaoMessage.domain.dto.Body774DTO;
import com.demo.kakaoMessage.domain.entity.Body774;
import com.demo.kakaoMessage.service.PushService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ApiController {

    private final PushService pushService;

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
                        Body774 body774 = body774DTO.toEntity(body774DTO.getCameraName(), body774DTO.getChannel(), body774DTO.getDeviceId(), body774DTO.getEventsType(), body774DTO.getSnapId(), body774DTO.getSnapPath(), body774DTO.getTrigger(), "N");
                        //pushService.save(body774);
                    }else if(eventsType.equals("394")) {
                        log.info("394 Alarm");
                        Body774 body774 = body774DTO.toEntity(body774DTO.getCameraName(), body774DTO.getChannel(), body774DTO.getDeviceId(), body774DTO.getEventsType(), body774DTO.getSnapId(), body774DTO.getSnapPath(), body774DTO.getTrigger(),"N");
                    }else if(eventsType.equals("389")) {
                        log.info("389 Alarm");
                        Body774 body774 = body774DTO.toEntity(body774DTO.getCameraName(), body774DTO.getChannel(), body774DTO.getDeviceId(), body774DTO.getEventsType(), body774DTO.getSnapId(), body774DTO.getSnapPath(), body774DTO.getTrigger(),"N");
                    }
                }
                break;
            case 775:
                log.info("This is Heartbeat Alarm");
                break;
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
