package com.fourfree.ff2011.mms_msg.repository;

import com.fourfree.ff2011.mms_msg.vo.MMSMsgVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.mms_msg.repository
 * 3. 작성일     : 2021. 06. 29. 오후 3:55
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Repository
public interface MMSMsgRepo extends JpaRepository<MMSMsgVO, Integer>, MMSMsgRepoCustom {

    List<MMSMsgVO> findAllByMsgkey(Integer msgKey);

    MMSMsgVO findByMsgkey(Integer msgKey);
}
