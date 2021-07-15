package com.fourfree.orasms.mms_log.repository;

import com.fourfree.orasms.mms_log.vo.MmsLogVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.mms_log.repository
 * 3. 작성일     : 2021. 07. 01. 오후 5:09
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface MmsLogRepo extends JpaRepository<MmsLogVO, Integer>, MmsLogRepoCustom {
    List<MmsLogVO> findAllBySentdateLessThanEqual(Date sentdate);

    List<MmsLogVO> findAllByStatus(String status);

    /**
     *  spring select 다중 in
     *  SELECT * FROM MMS_LOG WHERE MSGKEY in (:msgkey)
     *  참고 : https://javadeveloperzone.com/spring/spring-jpa-query-in-clause-example/
     */
    @Query(nativeQuery = true, value = "select * from MMS_LOG as a where a.msgkey in (:msgkeys)")
    List<MmsLogVO> findByMsgkey(@Param("msgkeys") List<Integer> msgkeys);

    MmsLogVO findByMsgkey(Integer msgkey);

}
