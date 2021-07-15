package com.fourfree.ff2011.mms_msg.repository.impl;

import com.fourfree.ff2011.mms_msg.repository.MMSMsgRepoCustom;
import com.fourfree.ff2011.mms_msg.vo.MMSMsgVO;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.mms_msg.repository.impl
 * 3. 작성일     : 2021. 07. 05. 오전 9:06
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public class MMSMsgRepoImpl extends QuerydslRepositorySupport implements MMSMsgRepoCustom {
    public MMSMsgRepoImpl() { super(MMSMsgVO.class); }

    @PersistenceContext public void setEntityManager(EntityManager entityManager) { super.setEntityManager(entityManager); }


}
