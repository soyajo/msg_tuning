package com.fourfree.orasms.sc_tran.service.impl;

import com.fourfree.common.jpa.OrasmsJpaConfig;
import com.fourfree.ff2011.sms_cron.service.SmsCronService;
import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;
import com.fourfree.orasms.sc_tran.service.ScTranService;
import com.fourfree.orasms.sc_tran.vo.ScTranVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.sc_tran.service.impl
 * 3. 작성일     : 2021. 07. 13. 오후 2:28
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Service
@Slf4j
@Transactional
public class ScTranServiceImpl implements ScTranService {
    @Autowired
    OrasmsJpaConfig orasmsJpaConfig;
    @Autowired
    SmsCronService smsCronService;

    @Override
    public void batch_insert() {

        List<SmsCronVO> smsCronVOS = smsCronService.selectAll_sc();
        List<ScTranVO> scTranVOS = new ArrayList<>();

        if (smsCronVOS != null) {
            for (SmsCronVO smsCronVO : smsCronVOS) {
                if (smsCronVO.getFlag().equals(0)) {
                    ScTranVO scTranVO = new ScTranVO();
                    if (smsCronVO.getSc_trNum() != null) {
                        scTranVO.setTrNum(smsCronVO.getSc_trNum());
                    }
                    if (smsCronVO.getSc_trId() != null) {
                        scTranVO.setTrSenddate(smsCronVO.getSc_trSenddate());
                    }
                    if (smsCronVO.getSc_trId() != null) {
                        scTranVO.setTrId(smsCronVO.getSc_trId());
                    }
                    if (smsCronVO.getSc_trSendstat() != null) {
                        scTranVO.setTrSendstat(smsCronVO.getSc_trSendstat());
                    }
                    if (smsCronVO.getSc_trRsltstat() != null) {
                        scTranVO.setTrRsltstat(smsCronVO.getSc_trRsltstat());
                    }
                    scTranVO.setTrMsgtype(smsCronVO.getSc_trMsgtype());
                    scTranVO.setTrPhone(smsCronVO.getSc_trPhone());
                    if (smsCronVO.getSc_trCallback() != null) {
                        scTranVO.setTrCallback(smsCronVO.getSc_trCallback());
                    }
                    if (smsCronVO.getSc_trRsltdate()  != null) {
                        scTranVO.setTrRsltdate(smsCronVO.getSc_trRsltdate());
                    }
                    if (smsCronVO.getSc_trModified() != null) {
                        scTranVO.setTrModified(smsCronVO.getSc_trModified());
                    }
                    if (smsCronVO.getSc_trMsg() != null) {
                        scTranVO.setTrMsg(smsCronVO.getSc_trMsg());
                    }
                    if (smsCronVO.getSc_trNet() != null) {
                        scTranVO.setTrNet(smsCronVO.getSc_trNet());
                    }
                    if (smsCronVO.getSc_trRealsenddate() != null) {
                        scTranVO.setTrRealsenddate(smsCronVO.getSc_trRealsenddate());
                    }
                    if (smsCronVO.getSc_etc1() != null) {
                        scTranVO.setTrEtc1(smsCronVO.getSc_etc1());
                    }
                    if (smsCronVO.getSc_etc2() != null) {
                        scTranVO.setTrEtc2(smsCronVO.getSc_etc2());
                    }
                    if (smsCronVO.getSc_etc3() != null) {
                        scTranVO.setTrEtc3(smsCronVO.getSc_etc3());
                    }
                    if (smsCronVO.getSc_etc4() != null) {
                        scTranVO.setTrEtc4(smsCronVO.getSc_etc4());
                    }
                    scTranVOS.add(scTranVO);
                }
            }

            JdbcBatchItemWriter<ScTranVO> writer = new JdbcBatchItemWriterBuilder<ScTranVO>()
                    .dataSource(orasmsJpaConfig.orasms_DataSource())
                    .sql("insert into SC_TRAN (TR_NUM,TR_SENDDATE,TR_ID,TR_SENDSTAT,TR_RSLTSTAT,TR_MSGTYPE,TR_PHONE,TR_CALLBACK,TR_RSLTDATE," +
                            "TR_MODIFIED,TR_MSG,TR_NET,TR_REALSENDDATE,TR_ETC1, TR_ETC2, TR_ETC3, TR_ETC4) " +
                            "values (:trNum, :trSenddate,:trId,:trSendstat,:trRsltstat,:trMsgtype,:trPhone,:trCallback,:trRsltdate," +
                            ":trModified,:trMsg,:trNet,:trRealsenddate,:trEtc1,:trEtc2,:trEtc3,:trEtc4)")
                    .beanMapped()
                    .build();
            writer.afterPropertiesSet();
            try {
                writer.write(scTranVOS);
                //update - sms_cron.flag = 1
                smsCronService.batch_update(smsCronVOS);
            } catch (Exception e) {
                log.info("###### {} ",e.getMessage());
            }
        }
    }


}
