package com.fourfree.orasms.sc_tran.repository;

import com.fourfree.orasms.sc_tran.vo.ScTranVO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.sc_tran.repository
 * 3. 작성일     : 2021. 07. 01. 오후 5:21
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface ScTranRepo extends JpaRepository<ScTranVO,Integer>,ScTranRepoCustom {

}
