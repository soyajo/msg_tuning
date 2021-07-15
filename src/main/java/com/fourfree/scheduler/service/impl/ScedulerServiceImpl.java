package com.fourfree.scheduler.service.impl;

import com.fourfree.common.jpa.FF2011JpaConfig;
import com.fourfree.common.jpa.OrasmsJpaConfig;
import com.fourfree.ff2011.mms_msg.service.MMSMsgService;
import com.fourfree.ff2011.mms_msg.vo.MMSMsgVO;
import com.fourfree.ff2011.sc_tran.service.SCTranService;
import com.fourfree.ff2011.sc_tran.vo.SCTranVO;
import com.fourfree.ff2011.sms_cron.service.SmsCronService;
import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;
import com.fourfree.orasms.mms_log.repository.MmsLogRepo;
import com.fourfree.orasms.mms_log.service.MmsLogService;
import com.fourfree.orasms.mms_log.vo.MmsLogVO;
import com.fourfree.orasms.mms_msg.service.MmsMsgService;
import com.fourfree.orasms.mms_msg.vo.MmsMsgVO;
import com.fourfree.orasms.sc_log.repository.ScLogRepo;
import com.fourfree.orasms.sc_log.service.ScLogService;
import com.fourfree.orasms.sc_log.vo.ScLogVO;
import com.fourfree.orasms.sc_tran.service.ScTranService;
import com.fourfree.scheduler.service.SchedulerService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.scheduler.service.impl
 * 3. 작성일     : 2021. 07. 09. 오후 2:46
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ScedulerServiceImpl implements SchedulerService {

    private final SmsCronService smsCronService;
    private final MmsMsgService mmsMsgService_orasms;
    private final FF2011JpaConfig ff2011JpaConfig;
    private final ScTranService scTranService_orasms;
    private final ScLogRepo scLogRepo;
    private final MmsLogRepo mmsLogRepo;


    @Override
    public void orasms_mms_msg_batch_insert() { mmsMsgService_orasms.batch_insert(); }

    @Override
    public void orasms_sc_tran_batch_insert() { scTranService_orasms.batch_insert(); }

    @Override
    public void ff2011_sms_cron_delete_or_mms_msg_status_update() {

        /**
         *  리스트 분할
         *  참고 : https://jinseongsoft.tistory.com/312
         */
        List<SmsCronVO> smsCronVOSCycle = smsCronService.selectAll_flag(1,"MMS");
        List<List<SmsCronVO>> listCycle = Lists.partition(smsCronVOSCycle, smsCronVOSCycle.size() / 4);

//        log.info("####listCyle {}.",listCycle);
        listCycle.stream().forEach(smsCronVOS -> {

            List<Integer> msgkeys = new ArrayList<>();

            smsCronVOS.stream().forEach(smsCronVO -> {
                msgkeys.add(smsCronVO.getMsgkey());
            });
            List<MmsLogVO> mmsLogVOS = mmsLogRepo.findByMsgkey(msgkeys);
            List<MMSMsgVO> mmsMsgVOS = new ArrayList<>();
            List<SmsCronVO> smsCronVOS1 = new ArrayList<>();

            if (mmsLogVOS != null) {

                for (MmsLogVO mmsLogVO : mmsLogVOS) {

                    MMSMsgVO mmsMsgVO = new MMSMsgVO();
                    mmsMsgVO.setMsgkey(mmsLogVO.getMsgkey());
                    mmsMsgVO.setStatus(mmsLogVO.getStatus());
                    mmsMsgVOS.add(mmsMsgVO);
                    if (mmsLogVO.getStatus().equals("3")) {
                        SmsCronVO smsCronVO = new SmsCronVO();
                        smsCronVO.setMsgkey(mmsLogVO.getMsgkey());
                        smsCronVOS1.add(smsCronVO);
                    }
                }

                if (mmsMsgVOS != null && mmsMsgVOS.size() > 0) {
                    JdbcBatchItemWriter<MMSMsgVO> writer1 = new JdbcBatchItemWriterBuilder<MMSMsgVO>()
                            .dataSource(ff2011JpaConfig.ff2011_DataSource())
                            .sql("UPDATE MMS_MSG SET STATUS = :status WHERE MSGKEY = :msgkey")
                            .beanMapped()
                            .build();
                    writer1.afterPropertiesSet();
                    try {
                        writer1.write(mmsMsgVOS);
                    } catch (Exception e) {
                        log.info("###### {} ",e.getMessage());
                    }
                }

                if (smsCronVOS1 != null && smsCronVOS1.size() > 0) {
                    JdbcBatchItemWriter<SmsCronVO> writer3 = new JdbcBatchItemWriterBuilder<SmsCronVO>()
                            .dataSource(ff2011JpaConfig.ff2011_DataSource())
                            .sql("DELETE FROM SMS_CRON WHERE MSGKEY = :msgkey")
                            .beanMapped()
                            .build();
                    writer3.afterPropertiesSet();
                    try {
                        writer3.write(smsCronVOS1);
                    } catch (Exception e) {
                        log.info("###### {} ",e.getMessage());
                    }
                }
            }
        });
    }

    @Override
    public void ff2011_sms_cron_delete_or_sc_tran_stauts_update() {

        /**
         *  리스트 분할
         *  참고 : https://jinseongsoft.tistory.com/312
         */
        List<SmsCronVO> smsCronVOSCycle = smsCronService.selectAll_flag(1,"SMS");

        List<List<SmsCronVO>> listCycle = Lists.partition(smsCronVOSCycle, smsCronVOSCycle.size() / 4);

        listCycle.stream().forEach(smsCronVOS -> {

            List<Integer> numbers = new ArrayList<>();

            smsCronVOS.stream().forEach(smsCronVO -> {
                numbers.add(smsCronVO.getMsgkey());
            });

            List<ScLogVO> scLogVOS = scLogRepo.findByTrNum(numbers);
            List<SCTranVO> scTranVOS = new ArrayList<>();
            List<SmsCronVO> smsCronVOS1 = new ArrayList<>();

            if (scLogVOS != null) {
                for (ScLogVO scLogVO : scLogVOS) {

                    SCTranVO scTranVO = new SCTranVO();
                    scTranVO.setTrNum(scLogVO.getTrNum());
                    scTranVO.setTrSendstat(scLogVO.getTrSendstat());
                    scTranVOS.add(scTranVO);

                    if (scLogVO.getTrSendstat().equals("3")) {
                        SmsCronVO smsCronVO = new SmsCronVO();
                        smsCronVO.setMsgkey(scLogVO.getTrNum());
                        smsCronVOS1.add(smsCronVO);
                    }
                }

                if (scTranVOS != null && scTranVOS.size() > 0) {
                    JdbcBatchItemWriter<SCTranVO> writer1 = new JdbcBatchItemWriterBuilder<SCTranVO>()
                            .dataSource(ff2011JpaConfig.ff2011_DataSource())
                            .sql("UPDATE SC_TRAN SET TR_SENDSTAT = :trSendstat WHERE TR_NUM = :trNum")
                            .beanMapped()
                            .build();
                    writer1.afterPropertiesSet();
                    try {
                        writer1.write(scTranVOS);
                    } catch (Exception e) {
                        log.info("###### {} ",e.getMessage());
                    }
                }

                if (smsCronVOS1 != null && smsCronVOS1.size() > 0) {
                    JdbcBatchItemWriter<SmsCronVO> writer3 = new JdbcBatchItemWriterBuilder<SmsCronVO>()
                            .dataSource(ff2011JpaConfig.ff2011_DataSource())
                            .sql("DELETE FROM SMS_CRON WHERE MSGKEY = :msgkey")
                            .beanMapped()
                            .build();
                    writer3.afterPropertiesSet();
                    try {
                        writer3.write(smsCronVOS1);
                    } catch (Exception e) {
                        log.info("###### {} ",e.getMessage());
                    }
                }
            }
        });
    }


}
