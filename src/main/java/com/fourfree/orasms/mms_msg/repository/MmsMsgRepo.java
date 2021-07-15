package com.fourfree.orasms.mms_msg.repository;

import com.fourfree.orasms.mms_msg.vo.MmsMsgVO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.mms_msg.repository
 * 3. 작성일     : 2021. 07. 01. 오후 4:56
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface MmsMsgRepo extends JpaRepository<MmsMsgVO, Integer>, MmsMsgRepoCustom{


}
