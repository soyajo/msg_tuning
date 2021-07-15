package com.fourfree.orasms.sc_log.repository;

import com.fourfree.orasms.mms_log.vo.MmsLogVO;
import com.fourfree.orasms.sc_log.vo.ScLogVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.sc_log.repository
 * 3. 작성일     : 2021. 07. 01. 오후 5:22
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */

public interface ScLogRepo extends JpaRepository<ScLogVO, Integer> {


    @Query(nativeQuery = true, value = "select * from SC_LOG as a where a.TR_NUM in (:numbers)")
    List<ScLogVO> findByTrNum(@Param("numbers") List<Integer> numbers);
}
