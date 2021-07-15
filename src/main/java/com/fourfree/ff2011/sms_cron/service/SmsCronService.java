package com.fourfree.ff2011.sms_cron.service;

import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;

import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.sms_cron.service
 * 3. 작성일     : 2021. 06. 30. 오후 12:54
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface SmsCronService {

    List<SmsCronVO> selectAll_mms();

    List<SmsCronVO> selectAll_sc();

    Long mms_count();

    void batch_insert();

    void batch_update(List<SmsCronVO> smsCronVOS);

    void deleteAll_msgKey(Integer msgKey);

    List<SmsCronVO> selectAll_msgKey(Integer msgKey);

    List<SmsCronVO> selectAll_flag(Integer flag, String type);

}
