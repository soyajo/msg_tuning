package com.fourfree.orasms.mms_log.service.impl;

import com.fourfree.common.jpa.OrasmsJpaConfig;
import com.fourfree.ff2011.mms_msg.vo.MMSMsgVO;
import com.fourfree.ff2011.sms_cron.service.SmsCronService;
import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;
import com.fourfree.orasms.mms_log.repository.MmsLogRepo;
import com.fourfree.orasms.mms_log.service.MmsLogService;
import com.fourfree.orasms.mms_log.vo.MmsLogVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.mms_log.service.impl
 * 3. 작성일     : 2021. 07. 07. 오후 4:48
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Slf4j
@Service
@Transactional
public class MmsLogServiceImpl implements MmsLogService {
    @Autowired
    MmsLogRepo mmsLogRepo;
    @Autowired
    SmsCronService smsCronService;
    @Autowired
    OrasmsJpaConfig orasmsJpaConfig;


    @Override
    public List<MmsLogVO> selectAll() {


        Date nowDate = new Date();
        List<MmsLogVO> mmsLogVOS = mmsLogRepo.findAllBySentdateLessThanEqual(nowDate);

        return mmsLogVOS;

    }

    @Override
    public List<MmsLogVO> selectAll_status(String status) {
        List<MmsLogVO> mmsLogVOS = mmsLogRepo.findAllByStatus(status);
        return mmsLogVOS;
    }

    @Override
    public List<MmsLogVO> selectAll_msgkey() {

        List<SmsCronVO> smsCronVOS = smsCronService.selectAll_flag(1,"MMS");
        List<Integer> msgkeys = new ArrayList<>();
        for (SmsCronVO smsCronVO : smsCronVOS) {
            msgkeys.add(smsCronVO.getMsgkey());
        }
        List<MmsLogVO> mmsLogVOS = mmsLogRepo.findByMsgkey(msgkeys);

        return mmsLogVOS;
    }
}
