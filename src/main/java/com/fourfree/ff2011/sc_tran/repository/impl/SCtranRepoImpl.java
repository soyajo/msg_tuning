package com.fourfree.ff2011.sc_tran.repository.impl;

import com.fourfree.ff2011.sc_tran.repository.SCTranRepoCustom;
import com.fourfree.ff2011.sc_tran.vo.SCTranVO;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.sc_tran.repository.impl
 * 3. 작성일     : 2021. 07. 05. 오전 11:20
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public class SCtranRepoImpl extends QuerydslRepositorySupport implements SCTranRepoCustom {
    public SCtranRepoImpl() {
        super(SCTranVO.class);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

}
