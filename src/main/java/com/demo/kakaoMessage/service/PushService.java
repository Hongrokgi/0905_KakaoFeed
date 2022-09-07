package com.demo.kakaoMessage.service;

import com.demo.kakaoMessage.domain.entity.Body774;
import com.demo.kakaoMessage.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PushService {
    private final AlarmRepository alarmRepository;

    @Transactional
    public Long save(Body774 body774) {
        return alarmRepository.save(body774).getId();
    }

}
