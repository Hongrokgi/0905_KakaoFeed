package com.demo.kakaoMessage.service;

import com.demo.kakaoMessage.controller.MessageController;
import com.demo.kakaoMessage.domain.entity.Body774;
import com.demo.kakaoMessage.domain.entity.QBody774;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static com.demo.kakaoMessage.domain.entity.QBody774.*;

@Component
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ScheduleService {
    private final EntityManager em;
    private JPAQueryFactory queryFactory;

    private final MessageService messageService;

    // 30초마다 실행 fixedDelay = 3000
    @Scheduled(cron = "30 * * * * *")
    public void doTask() {
        log.info("**************************** start schedule ****************************");
        queryFactory = new JPAQueryFactory(em);
        List<Body774> tasks = queryFactory
                .selectFrom(body774)
                .where(body774.sendYn.eq("N"))
                .fetch();
        log.info("해야할 일 : " + tasks.size());
        log.info("****** task Done ******");
        if(tasks.size() != 0) {
           messageService.sendMessage("zU_2SvthEESEW85zYn9l7_q2owVosk4Uxb8gtlJiCj102gAAAYMXQK4r");
        }else {
            log.info("지금은 해당사항이 없습니다.");
        }
    }
}
