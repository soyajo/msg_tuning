package com.fourfree.orasms.sc_log.service.impl;

import com.fourfree.ff2011.sms_cron.service.SmsCronService;
import com.fourfree.ff2011.sms_cron.vo.SmsCronVO;
import com.fourfree.orasms.mms_log.vo.MmsLogVO;
import com.fourfree.orasms.sc_log.repository.ScLogRepo;
import com.fourfree.orasms.sc_log.service.ScLogService;
import com.fourfree.orasms.sc_log.vo.ScLogVO;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.orasms.sc_log.service.impl
 * 3. 작성일     : 2021. 07. 14. 오전 8:52
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Service
@Transactional
@Slf4j
public class ScLogServiceImpl implements ScLogService {
    @Autowired
    ScLogRepo scLogRepo;
    @Autowired
    SmsCronService smsCronService;

    @Override
    public List<ScLogVO> selectAll_numbers() {

        List<SmsCronVO> smsCronVOS = smsCronService.selectAll_flag(1,"SMS");
        List<Integer> numbers = new ArrayList<>();

        for (SmsCronVO smsCronVO : smsCronVOS) {
            numbers.add(smsCronVO.getMsgkey());
        }
        List<ScLogVO> scLogVOS = scLogRepo.findByTrNum(numbers);
        return scLogVOS;
    }
}
