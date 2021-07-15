package com.fourfree.ff2011.sms_cron.repository;

import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.sms_cron.repository
 * 3. 작성일     : 2021. 06. 30. 오전 11:53
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Repository
public interface SmsCronRepo extends JpaRepository<SmsCronVO, Integer>, SmsCronRepoCustom {

    List<SmsCronVO> findAllBySendDateLessThanEqual(Date sendDate);

    void deleteAllByMsgkey(Integer msgKey);

    List<SmsCronVO> findAllByMsgkey(Integer msgKey);

    List<SmsCronVO> findAllByFlagAndType(Integer flag, String type);



    Long mms_count();
}
