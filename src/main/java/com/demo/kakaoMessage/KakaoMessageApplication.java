package com.demo.kakaoMessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KakaoMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakaoMessageApplication.class, args);
	}

}
