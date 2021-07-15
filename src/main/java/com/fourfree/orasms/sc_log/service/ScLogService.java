package com.fourfree.orasms.sc_log.service;

import com.fourfree.orasms.sc_log.vo.ScLogVO;

import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.sc_log.service
 * 3. 작성일     : 2021. 07. 14. 오전 8:52
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface ScLogService {

    List<ScLogVO> selectAll_numbers();
}
