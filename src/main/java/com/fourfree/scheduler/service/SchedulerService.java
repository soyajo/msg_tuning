package com.fourfree.scheduler.service;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.scheduler.service
 * 3. 작성일     : 2021. 07. 09. 오후 2:45
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
public interface SchedulerService {

    /**
     * ff2011_sms_cron와 ff2011_mms_msg을 join하고 flag=0 것만 select -> orasms_mms_msg에 batch_insert -> batch_insert한 list은 ff2011_sms_cron.flag를 1로 수정한다.
     */
    void orasms_mms_msg_batch_insert();

    void orasms_sc_tran_batch_insert();

    void ff2011_sms_cron_delete_or_mms_msg_status_update();

    void ff2011_sms_cron_delete_or_sc_tran_stauts_update();


}
