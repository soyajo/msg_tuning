package com.fourfree.ff2011.sms_cron.vo;

import com.fourfree.common.vo.BaseVO;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.sms_cron.vo
 * 3. 작성일     : 2021. 06. 30. 오전 11:51
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "SMS_CRON")
public class SmsCronVO extends BaseVO {

    // pk
    @Id
    private Integer msgkey;

    // sms, mms 구분
    private String type;

    // 문자발송시간
    private Date sendDate;

    // 등록일
    private Date regDate;

    //크론 반영 상태값 0 : 대기, 1: 문자서버 등록, 2: 결과 반영
    private Integer flag;


    /**
     * mms_msg 컬럼
     */
    @Transient
    private Integer mms_msgkey;

    // 제목
    @Transient
    private String mms_subject;
    // 고객 전화번호
    @Transient
    private String mms_phone;
    // 포프리 전화번호
    @Transient
    private String mms_callback;
    // 상태값
    @Transient
    private String mms_status;
    //
    @Transient
    private Date mms_reqdate;

    // 문자내용
    @Transient
    private String mms_msg;

    @Transient
    private Integer mms_fileCnt;

    @Transient
    private Integer mms_fileCntReal;

    @Transient
    private String mms_filePath1;

    @Transient
    @Column(name = "FILE_PATH1_SIZ")
    private Integer mms_filePath1Siz;

    @Transient
    private String mms_filePath2;

    @Transient
    @Column(name = "FILE_PATH2_SIZ")
    private Integer mms_filePath2Siz;

    @Transient
    private String mms_filePath3;

    @Transient
    @Column(name = "FILE_PATH3_SIZ")
    private Integer mms_filePath3Siz;

    @Transient
    private String mms_filePath4;

    @Transient
    @Column(name = "FILE_PATH4_SIZ")
    private Integer mms_filePath4Siz;

    @Transient
    private String mms_filePath5;

    @Transient
    @Column(name = "FILE_PATH5_SIZ")
    private Integer mms_filePath5Siz;

    @Transient
    private String mms_expiretime;

    @Transient
    private Date mms_sentdate;

    @Transient
    private Date mms_rsltdate;

    @Transient
    private Date mms_reportdate;

    @Transient
    private Date mms_terminateddate;

    @Transient
    private String mms_rslt;

    @Transient
    private String mms_type;

    @Transient
    private  String mms_telcoinfo;

    @Transient
    private  String mms_id;

    @Transient
    private  String mms_post;

    @Transient
    private  String mms_cdate;

    @Transient
    private  String mms_proty;

    @Transient
    private  String mms_etc1;

    @Transient
    private  String mms_etc2;

    @Transient
    private  String mms_etc3;

    @Transient
    private  Integer mms_etc4;

    /**
     *
     * sc_tran join
     *
      */


    @Transient
    private Integer sc_trNum;

    @Transient
    private Date sc_trSenddate;

    @Transient
    private String sc_trId;

    @Transient
    private String sc_trSendstat;

    @Transient
    private String sc_trRsltstat;

    @Transient
    private String sc_trMsgtype;

    @Transient
    private String sc_trPhone;

    @Transient
    private String sc_trCallback;

    @Transient
    private Date sc_trRsltdate;

    @Transient
    private Date sc_trModified;

    @Transient
    private String sc_trMsg;

    @Transient
    private String sc_trNet;

    @Transient
    private Date sc_trRealsenddate;

    @Transient
    private String sc_proty;

    @Transient
    private String sc_cdate;

    @Transient
    private String sc_etc1;

    @Transient
    private String sc_etc2;

    @Transient
    private String sc_etc3;

    @Transient
    private String sc_etc4;

}
