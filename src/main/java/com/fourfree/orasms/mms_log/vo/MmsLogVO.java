package com.fourfree.orasms.mms_log.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.mms_log.vo
 * 3. 작성일     : 2021. 07. 01. 오후 5:06
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "MMS_LOG")
public class MmsLogVO {

    @Id
    private Integer msgkey;

    // 제목
    private String subject;
    // 고객 전화번호
    private String phone;
    // 포프리 전화번호
    private String callback;
    // 상태값
    private String status;
    //
    private Date reqdate;

    // 문자내용
    private String msg;

    private Integer fileCnt;

    private Integer fileCntReal;

    private String expiretime;

    private Date sentdate;

    private Date rsltdate;

    private Date reportdate;

    private Date terminateddate;

    private String rslt;

    private String type;

    private  String telcoinfo;

    private String routeId;

    private  String id;

    private  String post;

    private  String etc1;

    private  String etc2;

    private  String etc3;

    private  Integer etc4;

    private String multiSeq;

    @Transient
    private List<Integer> msgkeys;
}
