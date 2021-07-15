package com.fourfree.orasms.mms_msg.service;

import com.fourfree.ff2011.mms_msg.vo.MMSMsgVO;
import com.fourfree.orasms.mms_msg.vo.MmsMsgVO;

import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.mms_msg.service
 * 3. 작성일     : 2021. 07. 08. 오후 3:07
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface MmsMsgService {

    void batch_insert();

    void deleteAll();

}
