package com.fourfree.orasms.sc_tran.repository.impl;

import com.fourfree.orasms.sc_tran.repository.ScTranRepoCustom;
import com.fourfree.orasms.sc_tran.vo.ScTranVO;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.sc_tran.repository.impl
 * 3. 작성일     : 2021. 07. 05. 오전 11:43
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public class ScTranRepoImpl extends QuerydslRepositorySupport implements ScTranRepoCustom {
    public ScTranRepoImpl() {
        super(ScTranVO.class);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }



}
