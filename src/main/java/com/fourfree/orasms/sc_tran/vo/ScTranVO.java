package com.fourfree.orasms.sc_tran.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.sc_log.vo
 * 3. 작성일     : 2021. 07. 01. 오후 5:11
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SC_LOG")
public class ScTranVO {
    @Id
    private Integer trNum;

    // 메세지전송할시간
    private Date trSenddate;

    // 고객번호
    private String trId;

    // 발송상태
    private String trSendstat;

    // 발송결과
    private String trRsltstat;

    // 문자전송형태
    private String trMsgtype;

    // 수신번호
    private String trPhone;

    // 발신번호
    private String trCallback;

    // 결과통보시간
    private Date trRsltdate;

    // 문자발생시간
    private Date trModified;

    // 전송메세지
    private String trMsg;

    // 최종통신사정보
    private String trNet;

    // 실제모듈발송시간
    private Date trRealsenddate;

    // 기타
    @Column(name = "TR_ETC1")
    private String trEtc1;

    // 기타
    @Column(name = "TR_ETC2")
    private String trEtc2;

    // 기타
    @Column(name = "TR_ETC3")
    private String trEtc3;

    // 기타
    @Column(name = "TR_ETC4")
    private String trEtc4;

    @Column(name = "TR_ETC5")
    private String trEtc5;

    @Column(name = "TR_ETC6")
    private String trEtc6;

    private String trRouteid;
}
