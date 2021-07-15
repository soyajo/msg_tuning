package com.fourfree.ff2011.sc_tran.vo;

import com.fourfree.common.vo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.sc_tran.vo
 * 3. 작성일     : 2021. 06. 30. 오후 12:29
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "SC_TRAN")
public class SCTranVO extends BaseVO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // 등록자
    private String proty;

    // 등록일자
    private String cdate;

    // 기타
    private String etc1;

    // 기타
    private String etc2;

    // 기타
    private String etc3;

    // 기타
    private String etc4;



}
