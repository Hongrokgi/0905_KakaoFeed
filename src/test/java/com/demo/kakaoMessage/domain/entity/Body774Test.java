package com.demo.kakaoMessage.domain.entity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import java.util.List;

import static com.demo.kakaoMessage.domain.entity.QBody774.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class Body774Test {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @Test
    public void startQueryDsl() throws Exception {
        //given
        queryFactory = new JPAQueryFactory(em);
        //when
        int size = queryFactory.selectFrom(body774).fetch().size();


        Assertions.assertEquals(2, size);
        //then
    }

    @Test
    public void countSendNo() throws Exception {
        //given
        queryFactory = new JPAQueryFactory(em);
        //when
        int n = queryFactory
                .selectFrom(body774)
                .where(body774.sendYn.eq("N"))
                .fetch().size();

        //then
        Assertions.assertEquals(2, n);
    }

}