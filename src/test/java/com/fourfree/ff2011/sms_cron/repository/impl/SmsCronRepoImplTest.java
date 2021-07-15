package com.fourfree.ff2011.sms_cron.repository.impl;

import com.fourfree.ff2011.mms_msg.vo.MMSMsgVO;
import com.fourfree.ff2011.mms_msg.vo.QMMSMsgVO;
import com.fourfree.ff2011.sms_cron.vo.QSmsCronVO;
import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.sms_cron.repository.impl
 * 3. 작성일     : 2021. 07. 06. 오후 2:15
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@SpringBootTest
@Transactional
class SmsCronRepoImplTest extends QuerydslRepositorySupport {

    public SmsCronRepoImplTest() {
        super(SmsCronVO.class);
    }

    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    QSmsCronVO qSmsCronVO = QSmsCronVO.smsCronVO;
    QMMSMsgVO qmmsMsgVO = QMMSMsgVO.mMSMsgVO;

    @Test
    public void joinTest() {
        JPQLQuery<SmsCronVO> query = from(qSmsCronVO);
        query.select(
                Projections.bean(SmsCronVO.class,
                        qmmsMsgVO.id.as("mmsId"),
                        qSmsCronVO.msgkey
                )
        );
        query.join(qmmsMsgVO).on(qmmsMsgVO.msgkey.eq(qSmsCronVO.msgkey));
        List<SmsCronVO> list = query.fetch();
        System.out.println("#########"+list);


    }
}