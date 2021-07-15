package com.fourfree.ff2011.sc_tran.repository;

import com.fourfree.ff2011.sc_tran.vo.SCTranVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.sc_tran.repository
 * 3. 작성일     : 2021. 06. 30. 오후 12:30
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Repository
public interface SCTranRepo extends JpaRepository<SCTranVO, Integer>, SCTranRepoCustom {

    List<SCTranVO> findAllBy();
}
