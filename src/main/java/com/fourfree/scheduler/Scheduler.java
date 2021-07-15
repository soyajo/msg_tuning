package com.fourfree.scheduler;

import com.fourfree.ff2011.mms_msg.service.MMSMsgService;
import com.fourfree.ff2011.sc_tran.service.SCTranService;
import com.fourfree.ff2011.sms_cron.service.SmsCronService;
import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;
import com.fourfree.orasms.mms_log.service.MmsLogService;
import com.fourfree.orasms.mms_log.vo.MmsLogVO;
import com.fourfree.orasms.mms_msg.service.MmsMsgService;
import com.fourfree.scheduler.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.msg_tuning
 * 3. 작성일     : 2021. 06. 28. 오후 3:22
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {

    private final MMSMsgService mmsMsgService_ff2011;
    private final SmsCronService smsCronService;
    private final SCTranService scTranService;
    private final MmsLogService mmsLogService;
    private final MmsMsgService mmsMsgService_orasms;
    private final SchedulerService schedulerService;
//    @Scheduled(cron = "*/5 * * * * *") // cron에 따라 실행
//    public void scheduleTaskUsingCronExpression() {
//        log.info("schedule1 동작하고 있음 : {}", Calendar.getInstance().getTime());
//    }
    @Scheduled(cron = "*/5 * * * * *")
    public void job1 () {
//        mmsMsgService_orasms.deleteAll();
//        schedulerService.orasms_mms_msg_batch_insert();
//        schedulerService.orasms_sc_tran_batch_insert();
        schedulerService.ff2011_sms_cron_delete_or_mms_msg_status_update();
//        schedulerService.ff2011_sms_cron_delete_or_sc_tran_stauts_update();



        System.out.println("하이");

    }




//    @Scheduled(cron = "0 15 10 15 * ?", zone = "Europe/Paris") // cron에 TimeZone 설정 추가
}
