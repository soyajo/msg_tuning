package com.fourfree.ff2011.mms_msg.service.impl;

import com.fourfree.common.util.CustomBeanUtils;
import com.fourfree.ff2011.mms_msg.repository.MMSMsgRepo;
import com.fourfree.ff2011.mms_msg.service.MMSMsgService;
import com.fourfree.ff2011.mms_msg.vo.MMSMsgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1. 프로젝트명 : msg_tuning
 * 2. 패키지명   : com.fourfree.scheduler.service.impl
 * 3. 작성일     : 2021. 06. 30. 오전 11:07
 * 4. 작성자     : 조소야
 * 5. 이메일     : whthdi4693@naver.com
 */
@Slf4j
@Service
public class MMSMsgServiceImpl implements MMSMsgService {
    @Autowired
    MMSMsgRepo mmsMsgRepo;


    @Override
    public List<MMSMsgVO> selectAll() {
        return mmsMsgRepo.findAll();
    }

    @Override
    public List<MMSMsgVO> selectAll_msgKey(Integer msgKey) {

        List<MMSMsgVO> mmsMsgVOS = mmsMsgRepo.findAllByMsgkey(msgKey);
//        log.debug("mms_msgService.selectAll() {}.",mmsMsgVOS);
        return mmsMsgVOS;
    }

    @Override
    public MMSMsgVO selectOne(Integer msgKey) {
        MMSMsgVO mmsMsgVO = mmsMsgRepo.findByMsgkey(msgKey);
        if (msgKey == null) {
            return new MMSMsgVO();
        }
        return mmsMsgVO;
    }

    @Override
    public void update(MMSMsgVO mmsMsgVO) {
        log.debug("mmsmsgvo {}.",mmsMsgVO);
        MMSMsgVO mmsMsgVO1 = this.selectOne(mmsMsgVO.getMsgkey());
        if(mmsMsgVO != null){
            log.debug("mmsmsgvo1 {}.",mmsMsgVO1);
            CustomBeanUtils.copyProperties(mmsMsgVO,mmsMsgVO1);
        }
    }
}
