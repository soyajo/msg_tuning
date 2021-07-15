package com.fourfree.orasms.mms_msg.repository.impl;

import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;
import com.fourfree.orasms.mms_log.vo.MmsLogVO;
import com.fourfree.orasms.mms_log.vo.QMmsLogVO;
import com.fourfree.orasms.mms_msg.repository.MmsMsgRepoCustom;
import com.fourfree.orasms.mms_msg.vo.MmsMsgVO;
import com.fourfree.orasms.mms_msg.vo.QMmsMsgVO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.mms_msg.repository.impl
 * 3. 작성일     : 2021. 07. 05. 오전 11:38
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public class MmsMsgRepoImpl extends QuerydslRepositorySupport implements MmsMsgRepoCustom {
    public MmsMsgRepoImpl() {
        super(MmsLogVO.class);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }




}
