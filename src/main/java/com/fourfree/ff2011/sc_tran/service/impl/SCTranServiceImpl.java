package com.fourfree.ff2011.sc_tran.service.impl;

import com.fourfree.ff2011.sc_tran.repository.SCTranRepo;
import com.fourfree.ff2011.sc_tran.service.SCTranService;
import com.fourfree.ff2011.sc_tran.vo.SCTranVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.ff2011.sc_tran.service.impl
 * 3. 작성일     : 2021. 06. 30. 오후 12:29
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SCTranServiceImpl implements SCTranService {
    private final SCTranRepo scTranRepo;

    @Override
    public List<SCTranVO> selectAll() {
        List<SCTranVO> SCTranVOS = scTranRepo.findAllBy();
//        log.debug("scTranService.selectAll() {}.", scTranVOS);
        return SCTranVOS;
    }
}
