package com.demo.kakaoMessage.domain.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Body774 {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cameraName;

    @Column(nullable = false)
    private String channel;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private String eventsType;

    @Column(nullable = false)
    private String snapId;

    @Column(nullable = false)
    private String snapPath;

    @Column(nullable = false)
    private String trigger;

    @Column(nullable = false)
    private String sendYn;

    @Builder
    public Body774(String cameraName, String channel, String deviceId, String eventsType, String snapId, String snapPath, String trigger, String sendYn) {
        this.cameraName = cameraName;
        this.channel = channel;
        this.deviceId = deviceId;
        this.eventsType = eventsType;
        this.snapId = snapId;
        this.snapPath = snapPath;
        this.trigger = trigger;
        this.sendYn = sendYn;
    }

    public void Update() {
        this.sendYn="Y";
    }
}
