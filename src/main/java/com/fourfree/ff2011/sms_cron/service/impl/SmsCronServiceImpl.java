package com.fourfree.ff2011.sms_cron.service.impl;

import com.drew.lang.DateUtil;
import com.fourfree.ff2011.sms_cron.repository.SmsCronRepo;
import com.fourfree.ff2011.sms_cron.service.SmsCronService;
import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.sms_cron.service.impl
 * 3. 작성일     : 2021. 06. 30. 오전 11:51
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SmsCronServiceImpl implements SmsCronService {
    private final SmsCronRepo smsCronRepo;
    private final DataSource dataSource;


    @Override
    public List<SmsCronVO> selectAll_msgKey(Integer msgKey) {
        List<SmsCronVO> smsCronVOS = smsCronRepo.findAllByMsgkey(msgKey);
        return smsCronVOS;
    }

    @Override
    public List<SmsCronVO> selectAll_mms() {
//        List<SmsCronVO> smsCronVOS = smsCronRepo.findAllBySendDateLessThanEqual(new Date());
        List<SmsCronVO> smsCronVOS = smsCronRepo.selectAll_mms();
        return smsCronVOS;
    }

    @Override
    public List<SmsCronVO> selectAll_sc() {
//        List<SmsCronVO> smsCronVOS = smsCronRepo.findAllBySendDateLessThanEqual(new Date());
        List<SmsCronVO> smsCronVOS = smsCronRepo.selectAll_sc();
//        log.debug("smsCronService.selectAll() {}.", smsCronVOS);
        return smsCronVOS;
    }

    @Override
    public Long mms_count() {
        return smsCronRepo.mms_count();
    }

    @Transactional
    @Override
    public void batch_insert() {

        JdbcBatchItemWriter<SmsCronVO> writer = new JdbcBatchItemWriterBuilder<SmsCronVO>()
                .dataSource(dataSource)
                .sql("insert into ITEM_JDBC (name,description) values (:name,:description)")
                .beanMapped()
                .build();

        writer.afterPropertiesSet();
        List<SmsCronVO> smsCronVOS = new ArrayList<>();
        List<SmsCronVO> smsCronVOS1 = this.selectAll_mms();

        for (long i = 0; i < smsCronVOS1.size(); i++) {

            SmsCronVO smsCronVO = new SmsCronVO().builder()
                    .type("SMS")
                    .sendDate(new Date())
                    .regDate(new Date())
                    .flag(0)
                    .mms_subject("포프리")
                    .mms_phone("01046938128")
                    .mms_callback("1588-0029")
                    .mms_status("3")
                    .mms_reqdate(new Date())
                    .mms_msg("포프리\n" +
                            "신선한 건강식 초란이 나오고 있습니다^^ 품질 좋은 시기 맞춰서 건강식, 생식, 아이들 간식 이유식으로 예전 계란 가격 그대로 초란 이용 해보세요 ^^ 한달 1팩 부터 직배 가능")
                    .mms_fileCnt(0)
                    .mms_fileCntReal(0)
                    .mms_expiretime("43200")
                    .mms_sentdate(new Date())
                    .mms_rsltdate(new Date())
                    .mms_reportdate(new Date())
                    .mms_terminateddate(new Date())
                    .mms_rslt("1000")
                    .mms_type("0")
                    .mms_telcoinfo("SKT")
                    .mms_id("212022400179")
                    .mms_cdate("20140102")
                    .mms_proty("FTD001DC")
                    .build();


            smsCronVOS.add(smsCronVO);
        }

        // saveAll - insert 와 write - batchInsert 비교하기
//        System.out.println("saveAll##시작시간#####"+format_time2);
//        itemJpaRepo.saveAll(itemJdbcVOS1);

//        System.out.println("saveAll##종료시간#####"+format_time2);
        try {
            writer.write(smsCronVOS);
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
    }

    @Override
    public void deleteAll_msgKey(Integer msgKey) {
        smsCronRepo.deleteAllByMsgkey(msgKey);
    }

    @Override
    public void batch_update(List<SmsCronVO> smsCronVOS) {

//        List<SmsCronVO> smsCronVOS1 = selectAll_mms();
//        smsCronVOS.addAll(smsCronVOS1);
        if (smsCronVOS != null) {
            JdbcBatchItemWriter<SmsCronVO> writer1 = new JdbcBatchItemWriterBuilder<SmsCronVO>()
                    .dataSource(dataSource)
                    .sql("UPDATE SMS_CRON SET FLAG=1 WHERE MSGKEY = :msgkey")
                    .beanMapped()
                    .build();
            writer1.afterPropertiesSet();
            try {
                writer1.write(smsCronVOS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<SmsCronVO> selectAll_flag(Integer flag, String type) {
        List<SmsCronVO> smsCronVOS = smsCronRepo.findAllByFlagAndType(flag,type);
        return smsCronVOS;
    }
}
