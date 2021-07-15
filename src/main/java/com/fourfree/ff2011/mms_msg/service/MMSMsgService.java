package com.fourfree.ff2011.mms_msg.service;

import com.fourfree.ff2011.mms_msg.vo.MMSMsgVO;

import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.scheduler.service
 * 3. 작성일     : 2021. 06. 30. 오전 11:08
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface MMSMsgService {


    List<MMSMsgVO> selectAll_msgKey(Integer msgKey);

    List<MMSMsgVO> selectAll();

    void update(MMSMsgVO mmsMsgVO);

    MMSMsgVO selectOne(Integer msgKey);

}
