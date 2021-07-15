package com.fourfree.ff2011.sms_cron.repository.impl;

import com.fourfree.ff2011.mms_msg.vo.QMMSMsgVO;
import com.fourfree.ff2011.sc_tran.vo.QSCTranVO;
import com.fourfree.ff2011.sms_cron.repository.SmsCronRepoCustom;
import com.fourfree.ff2011.sms_cron.vo.QSmsCronVO;
import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.sms_cron.repository.impl
 * 3. 작성일     : 2021. 07. 05. 오전 11:26
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public class SmsCronRepoImpl extends QuerydslRepositorySupport implements SmsCronRepoCustom {
    public SmsCronRepoImpl() {
        super(SmsCronVO.class);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    QSmsCronVO qSmsCronVO = QSmsCronVO.smsCronVO;
    QMMSMsgVO qmmsMsgVO = QMMSMsgVO.mMSMsgVO;
    QSCTranVO qscTranVO = QSCTranVO.sCTranVO;


    @Override
    public List<SmsCronVO> selectAll_mms() {

        JPQLQuery<SmsCronVO> query = from(qSmsCronVO);
        query.select(
                Projections.bean(SmsCronVO.class,
                        qSmsCronVO.msgkey,
                        qSmsCronVO.flag,
                        qSmsCronVO.regDate,
                        qSmsCronVO.sendDate,
                        qSmsCronVO.type,
                        qmmsMsgVO.msgkey.as("mms_msgkey"),
                        qmmsMsgVO.subject.as("mms_subject"),
                        qmmsMsgVO.phone.as("mms_phone"),
                        qmmsMsgVO.callback.as("mms_callback"),
                        qmmsMsgVO.status.as("mms_status"),
                        qmmsMsgVO.reqdate.as("mms_reqdate"),
                        qmmsMsgVO.msg.as("mms_msg"),
                        qmmsMsgVO.fileCnt.as("mms_fileCnt"),
                        qmmsMsgVO.fileCntReal.as("mms_fileCntReal"),
                        qmmsMsgVO.filePath1.as("mms_filePath1"),
                        qmmsMsgVO.filePath1Siz.as("mms_filePath1Siz"),
                        qmmsMsgVO.filePath2.as("mms_filePath2"),
                        qmmsMsgVO.filePath1Siz.as("mms_filePath2Siz"),
                        qmmsMsgVO.filePath3.as("mms_filePath3"),
                        qmmsMsgVO.filePath3Siz.as("mms_filePath3Siz"),
                        qmmsMsgVO.filePath4.as("mms_filePath4"),
                        qmmsMsgVO.filePath4Siz.as("mms_filePath4Siz"),
                        qmmsMsgVO.filePath5.as("mms_filePath5"),
                        qmmsMsgVO.filePath5Siz.as("mms_filePath5Siz"),
                        qmmsMsgVO.expiretime.as("mms_expiretime"),
                        qmmsMsgVO.sentdate.as("mms_sentdate"),
                        qmmsMsgVO.rsltdate.as("mms_rsltdate"),
                        qmmsMsgVO.reportdate.as("mms_reportdate"),
                        qmmsMsgVO.terminateddate.as("mms_terminateddate"),
                        qmmsMsgVO.rslt.as("mms_rslt"),
                        qmmsMsgVO.type.as("mms_type"),
                        qmmsMsgVO.telcoinfo.as("mms_telcoinfo"),
                        qmmsMsgVO.id.as("mms_id"),
                        qmmsMsgVO.post.as("mms_post"),
                        qmmsMsgVO.cdate.as("mms_cdate"),
                        qmmsMsgVO.proty.as("mms_proty"),
                        qmmsMsgVO.etc1.as("mms_etc1"),
                        qmmsMsgVO.etc2.as("mms_etc2"),
                        qmmsMsgVO.etc3.as("mms_etc3"),
                        qmmsMsgVO.etc4.as("mms_etc4")
                )
        );

        query.leftJoin(qmmsMsgVO).on(
                qmmsMsgVO.msgkey.eq(qSmsCronVO.msgkey)
        );
        query.where(qSmsCronVO.sendDate.before(new Date())
                .and(qSmsCronVO.flag.eq(0))
                .and(qSmsCronVO.type.eq("MMS"))
                .and(qmmsMsgVO.phone.isNotNull())
        );
        return query.fetch();
    }

    @Override
    public List<SmsCronVO> selectAll_sc(){

        JPQLQuery<SmsCronVO> query = from(qSmsCronVO);
        query.select(
                Projections.bean(SmsCronVO.class,
                        qSmsCronVO.msgkey,
                        qSmsCronVO.flag,
                        qSmsCronVO.regDate,
                        qSmsCronVO.sendDate,
                        qSmsCronVO.type,
                        qscTranVO.trNum.as("sc_trNum"),
                        qscTranVO.trSenddate.as("sc_trSenddate"),
                        qscTranVO.trId.as("sc_trId"),
                        qscTranVO.trSendstat.as("sc_trSendstat"),
                        qscTranVO.trRsltstat.as("sc_trRsltstat"),
                        qscTranVO.trMsgtype.as("sc_trMsgtype"),
                        qscTranVO.trPhone.as("sc_trPhone"),
                        qscTranVO.trCallback.as("sc_trCallback"),
                        qscTranVO.trRsltdate.as("sc_trRsltdate"),
                        qscTranVO.trModified.as("sc_trModified"),
                        qscTranVO.trMsg.as("sc_trMsg"),
                        qscTranVO.trNet.as("sc_trNet"),
                        qscTranVO.trRealsenddate.as("sc_trRealsenddate"),
                        qscTranVO.proty.as("sc_proty"),
                        qscTranVO.cdate.as("sc_cdate"),
                        qscTranVO.etc1.as("sc_etc1"),
                        qscTranVO.etc2.as("sc_etc2"),
                        qscTranVO.etc3.as("sc_etc3"),
                        qscTranVO.etc4.as("sc_etc4")

                )
        );

        query.leftJoin(qscTranVO).on(
                qscTranVO.trNum.eq(qSmsCronVO.msgkey)
        );
        query.where(qSmsCronVO.sendDate.before(new Date())
                .and(qSmsCronVO.flag.eq(0))
                .and(qSmsCronVO.type.eq("SMS"))
                .and(qscTranVO.trPhone.isNotNull())
        );

        return query.fetch();
    }

    public Long mms_count() {

        JPQLQuery<SmsCronVO> query = from(qSmsCronVO);
        query.select(
                Projections.fields(SmsCronVO.class,
                        qmmsMsgVO.id.as("mms"),
                        qSmsCronVO.msgkey
                )
        );
        query.join(qSmsCronVO).on(
                qSmsCronVO.msgkey.eq(qmmsMsgVO.msgkey)
        );

        return query.fetchCount();
    }



}
