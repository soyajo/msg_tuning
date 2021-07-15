package com.fourfree.ff2011.mms_msg.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Date;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.mms_msg.vo
 * 3. 작성일     : 2021. 06. 29. 오후 2:01
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "MMS_MSG")
public class MMSMsgVO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer msgkey;

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

    @Column(name = "FILE_CNT_REAL")
    private Integer fileCntReal;

    private String filePath1;

    @Column(name = "FILE_PATH1_SIZ")
    private Integer filePath1Siz;

    private String filePath2;

    @Column(name = "FILE_PATH2_SIZ")
    private Integer filePath2Siz;

    private String filePath3;

    @Column(name = "FILE_PATH3_SIZ")
    private Integer filePath3Siz;

    private String filePath4;

    @Column(name = "FILE_PATH4_SIZ")
    private Integer filePath4Siz;

    private String filePath5;

    @Column(name = "FILE_PATH5_SIZ")
    private Integer filePath5Siz;

    private String expiretime;

    private Date sentdate;

    private Date rsltdate;

    private Date reportdate;

    private Date terminateddate;

    private String rslt;

    private String type;

    private  String telcoinfo;

    private  String id;

    private  String post;

    private  String cdate;

    private  String proty;

    private  String etc1;

    private  String etc2;

    private  String etc3;

    private  Integer etc4;


}
