package com.fourfree.orasms.mms_msg.service.impl;

import com.fourfree.common.jpa.FF2011JpaConfig;
import com.fourfree.common.jpa.OrasmsJpaConfig;
import com.fourfree.ff2011.mms_msg.vo.MMSMsgVO;
import com.fourfree.ff2011.sms_cron.service.SmsCronService;
import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;
import com.fourfree.orasms.mms_msg.repository.MmsMsgRepo;
import com.fourfree.orasms.mms_msg.service.MmsMsgService;
import com.fourfree.orasms.mms_msg.vo.MmsMsgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.mms_msg.service.impl
 * 3. 작성일     : 2021. 07. 08. 오후 3:08
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Service
@Slf4j
@Transactional
public class MmsMsgSerivceImpl implements MmsMsgService {
    @Autowired
    OrasmsJpaConfig orasmsJpaConfig;

    @Autowired
    FF2011JpaConfig ff2011JpaConfig;

    @Autowired
    SmsCronService smsCronService;

    @Autowired
    MmsMsgRepo mmsMsgRepo;


    @Override
    public void batch_insert() {



        List<SmsCronVO> smsCronVOS = smsCronService.selectAll_mms();
        List<MmsMsgVO> mmsMsgVOS = new ArrayList<>();

        if (smsCronVOS != null) {
            for (SmsCronVO smsCronVO : smsCronVOS) {
                if (smsCronVO.getFlag().equals(0)) {
                    MmsMsgVO mmsMsgVO = new MmsMsgVO();
                    if (smsCronVO.getMsgkey() != null) {
                        mmsMsgVO.setMsgkey(smsCronVO.getMsgkey());
                    }
                    if (smsCronVO.getMms_subject() != null) {
                        mmsMsgVO.setSubject(smsCronVO.getMms_subject());
                    }
                    mmsMsgVO.setPhone(smsCronVO.getMms_phone());
                    if (smsCronVO.getMms_callback() != null) {
                        mmsMsgVO.setCallback(smsCronVO.getMms_callback());
                    }
                    if (smsCronVO.getMms_status() != null) {
                        mmsMsgVO.setStatus(smsCronVO.getMms_status());
                    }
                    if (smsCronVO.getMms_reqdate() != null) {
                        mmsMsgVO.setReqdate(smsCronVO.getMms_reqdate());
                    }
                    if (smsCronVO.getMms_msg() != null) {
                        mmsMsgVO.setMsg(smsCronVO.getMms_msg());
                    }
                    if (smsCronVO.getMms_fileCnt() != null) {
                        mmsMsgVO.setFileCnt(smsCronVO.getMms_fileCnt());
                    } else {
                        mmsMsgVO.setFileCnt(0);
                    }
                    if (smsCronVO.getMms_fileCntReal() != null) {
                        mmsMsgVO.setFileCntReal(smsCronVO.getMms_fileCntReal());
                    }
                    if (smsCronVO.getMms_filePath1() != null) {
                        mmsMsgVO.setFilePath1(smsCronVO.getMms_filePath1());
                    }
                    if (smsCronVO.getMms_filePath1Siz() != null) {
                        mmsMsgVO.setFilePath1Siz(smsCronVO.getMms_filePath1Siz());
                    }
                    if (smsCronVO.getMms_filePath2() != null) {
                        mmsMsgVO.setFilePath2(smsCronVO.getMms_filePath2());
                    }
                    if (smsCronVO.getMms_filePath2Siz() != null) {
                        mmsMsgVO.setFilePath2Siz(smsCronVO.getMms_filePath2Siz());
                    }
                    if (smsCronVO.getMms_filePath3() != null) {
                        mmsMsgVO.setFilePath3(smsCronVO.getMms_filePath3());
                    }
                    if (smsCronVO.getMms_filePath3Siz() != null) {
                        mmsMsgVO.setFilePath3Siz(smsCronVO.getMms_filePath3Siz());
                    }
                    if (smsCronVO.getMms_filePath4() != null) {
                        mmsMsgVO.setFilePath4(smsCronVO.getMms_filePath4());
                    }
                    if (smsCronVO.getMms_filePath4Siz() != null) {
                        mmsMsgVO.setFilePath4Siz(smsCronVO.getMms_filePath4Siz());
                    }
                    if (smsCronVO.getMms_filePath5() != null) {
                        mmsMsgVO.setFilePath5(smsCronVO.getMms_filePath5());
                    }
                    if (smsCronVO.getMms_filePath5Siz() != null) {
                        mmsMsgVO.setFilePath5Siz(smsCronVO.getMms_filePath5Siz());
                    }
                    if (smsCronVO.getMms_expiretime() != null) {
                        mmsMsgVO.setExpiretime(smsCronVO.getMms_expiretime());
                    }
                    if (smsCronVO.getMms_sentdate() != null) {
                        mmsMsgVO.setSentdate(smsCronVO.getMms_sentdate());
                    }
                    if (smsCronVO.getMms_rsltdate() != null) {
                        mmsMsgVO.setRsltdate(smsCronVO.getMms_rsltdate());
                    }
                    if (smsCronVO.getMms_reportdate() != null) {
                        mmsMsgVO.setReportdate(smsCronVO.getMms_reportdate());
                    }
                    if (smsCronVO.getMms_terminateddate() != null) {
                        mmsMsgVO.setTerminateddate(smsCronVO.getMms_terminateddate());
                    }
                    if (smsCronVO.getMms_rslt() != null) {
                        mmsMsgVO.setRslt(smsCronVO.getMms_rslt());
                    }
                    if (smsCronVO.getMms_type() != null) {
                        mmsMsgVO.setType(smsCronVO.getType());
                    }
                    if (smsCronVO.getMms_telcoinfo() != null) {
                        mmsMsgVO.setTelcoinfo(smsCronVO.getMms_telcoinfo());
                    }
                    mmsMsgVO.setRouteId("BM0020");
                    if (smsCronVO.getMms_id() != null) {
                        mmsMsgVO.setId(smsCronVO.getMms_id());
                    }
                    if (smsCronVO.getMms_post() != null) {
                        mmsMsgVO.setPost(smsCronVO.getMms_post());
                    }
                    if (smsCronVO.getMms_etc1() != null) {
                        mmsMsgVO.setEtc1(smsCronVO.getMms_etc1());
                    }
                    if (smsCronVO.getMms_etc2() != null) {
                        mmsMsgVO.setEtc2(smsCronVO.getMms_etc2());
                    }
                    if (smsCronVO.getMms_etc3() != null) {
                        mmsMsgVO.setEtc3(smsCronVO.getMms_etc3());
                    }
                    if (smsCronVO.getMms_etc4() != null) {
                        mmsMsgVO.setEtc4(smsCronVO.getMms_etc4());
                    }

                    mmsMsgVOS.add(mmsMsgVO);
                }
            }

            JdbcBatchItemWriter<MmsMsgVO> writer = new JdbcBatchItemWriterBuilder<MmsMsgVO>()
                    .dataSource(orasmsJpaConfig.orasms_DataSource())
                    .sql("insert into MMS_MSG (MSGKEY,SUBJECT,PHONE,CALLBACK,STATUS,REQDATE,MSG,FILE_CNT,FILE_CNT_REAL," +
                            "FILE_PATH1,FILE_PATH1_SIZ,FILE_PATH2,FILE_PATH2_SIZ,FILE_PATH3,FILE_PATH3_SIZ,FILE_PATH4,FILE_PATH4_SIZ,FILE_PATH5,FILE_PATH5_SIZ," +
                            "EXPIRETIME,SENTDATE,RSLTDATE,REPORTDATE,TERMINATEDDATE,RSLT,TYPE,TELCOINFO,ROUTE_ID,ID,POST,ETC1,ETC2,ETC3,ETC4) " +
                            "values (:msgkey,:subject,:phone,:callback,:status,:reqdate,:msg,:fileCnt,:fileCntReal," +
                            ":filePath1,:filePath1Siz,:filePath2,:filePath2Siz,:filePath3,:filePath3Siz,:filePath4,:filePath4Siz,:filePath5,:filePath5Siz," +
                            ":expiretime,:sentdate,:rsltdate,:reportdate,:terminateddate,:rslt,:type,:telcoinfo,:routeId,:id,:post,:etc1,:etc2,:etc3,:etc4)")
                    .beanMapped()
                    .build();

            writer.afterPropertiesSet();
            try {
                writer.write(mmsMsgVOS);
                //update - sms_cron.flag = 1
                smsCronService.batch_update(smsCronVOS);
            } catch (Exception e) {
                log.debug("###### {} ",e.getMessage());
            }
        }
    }

    @Override
    public void deleteAll() {
        mmsMsgRepo.deleteAll();
    }

}
