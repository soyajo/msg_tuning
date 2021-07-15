package com.fourfree.orasms.mms_log.service;

import com.fourfree.orasms.mms_log.vo.MmsLogVO;

import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.mms_log.service
 * 3. 작성일     : 2021. 07. 07. 오후 4:47
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface MmsLogService {
    List<MmsLogVO> selectAll();

    List<MmsLogVO> selectAll_status(String status);

    List<MmsLogVO> selectAll_msgkey();
}
