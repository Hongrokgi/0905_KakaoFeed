package com.demo.kakaoMessage.domain.dto;

import com.demo.kakaoMessage.domain.entity.Body774;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Body774DTO {
    @JsonProperty("body_attr")
    private BodyAttr bodyAttr;              // When obj_label is 2, body attributes

    @JsonProperty("camera_name")
    private String cameraName;              // Camera name

    @JsonProperty("channel")
    private String channel;                 // Channel; M4s range:[1,16], M8s range[1,32]

    @JsonProperty("device_id")
    private String deviceId;                // Device Id

    @JsonProperty("events_attr")
    private EventsAttr eventsAttr;

    @JsonProperty("events_off_type")
    private String eventsOffType;           // Alarm cancellation event, empty means no body/vehicle /fire alarm

    @JsonProperty("events_status")
    private int eventsStatus;

    @JsonProperty("events_type")
    private String eventsType;              // Alarm event, empty means no body/vehicle/fire alarm

    @JsonProperty("obj_label")
    private int objLabel;                   // Identification(1:face, 2:body, 8:fire 9:fire extinguisher)

    @JsonProperty("pos_bottom")
    private int posBottom;                  // Face coordinates bottom right Y

    @JsonProperty("pos_left")
    private int posLeft;                    // Face coordinates top left X

    @JsonProperty("pos_right")
    private int posRight;                   // Face coordinates bottom right X

    @JsonProperty("pos_top")
    private int posTop;                     // Face coordinates top left Y

    @JsonProperty("position")
    private String position;                // Camera position

    @JsonProperty("quality")
    private int quality;                    // Quality Score, range:[0,100]

    @JsonProperty("snap_feat")
    private String snapFeat;                // Capture image features

    @JsonProperty("snap_id")
    private String snapId;                  // Capture image id

    @JsonProperty("snap_path")
    private String snapPath;                // Capture image path

    @JsonProperty("trigger")
    private String trigger;                 // Trigger time(capture time)

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public class BodyAttr {

        @JsonProperty("cap_style")
        private String capStyle;

        @JsonProperty("coat_color")
        private String coatColor;

        @JsonProperty("gender_code")
        private String genderCode;

        @JsonProperty("st_age")
        private String stAge;

        @JsonProperty("st_phone_status")
        private String stPhoneStatus;

        @JsonProperty("st_pose")
        private String stPose;

        @JsonProperty("st_reflective_clothes")
        private String stReflectiveClothes;

        @JsonProperty("st_respirator_V2")
        private String stRespiratorV2;

        @JsonProperty("st_smocking")
        private String stSmocking;

        @JsonProperty("st_uniform")
        private String stUniform;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public class EventsAttr {

        @JsonProperty("crowd_num")
        private int crowdNum;                   // Personnel quantity gathered

        @JsonProperty("crowd_threshold")
        private int crowdThreshold;             // Gathering threshold

        @JsonProperty("helmet_type")
        private String helmetType;              // Hat Type: bonnet: Beanie, cap:Peaked cap, bucket_hat:Bucket hat, st_hard_hat: Helmet

        @JsonProperty("leave_num_threshold")
        private int leaveNumThreshold;          // Off-duty alarm trigger duration threshold

        @JsonProperty("leave_time_threshold")
        private int leaveTimeThreshold;         // Off-duty alarm trigger duration threshold

        @JsonProperty("over_boundary_direction")
        private int overBoundaryDirection;

        @JsonProperty("over_boundary_num1")
        private int overBoundaryNum1;           // Line crossing personnel quantity in direction 1

        @JsonProperty("over_boundary_num2")
        private int overBoundaryNum2;           // Line crossing personnel quantity in direction 2

        @JsonProperty("work_cloth_color")
        private String workClothColor;          // Uniform color : black, white, gray, red, yellow, blue, green, purple

        @JsonProperty("work_cloth_type")
        private String workClothType;           // st_worker_uniform:worker uniform / st_common_clothing:ordinary clothing / st_office_uniform : office uniform / st_chef_uniform : chef uniform / st_medical_uniform : medical uniform / st_police_uniform : police uniform / st_firefighter_uniform : firefighter uniform / st_reflective_clothing : reflective clothing
    }

    public Body774 toEntity(String cameraName, String channel, String deviceId, String eventsType, String snapId, String snapPath, String trigger, String sendYn) {
        return Body774.builder()
                .cameraName(cameraName)
                .channel(channel)
                .deviceId(deviceId)
                .eventsType(eventsType)
                .snapId(snapId)
                .snapPath(snapPath)
                .trigger(trigger)
                .sendYn(sendYn)
                .build();
    }
}



