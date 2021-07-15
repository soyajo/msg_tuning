package com.fourfree.ff2011.sms_cron.repository;

import com.fourfree.ff2011.sc_tran.vo.SCTranVO;
import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;

import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.sms_cron.repository
 * 3. 작성일     : 2021. 07. 05. 오전 11:25
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface SmsCronRepoCustom {
    List<SmsCronVO> selectAll_mms();

    List<SmsCronVO> selectAll_sc();

    Long mms_count();
}
