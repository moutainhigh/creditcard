package com.credit.service.impl;

import com.credit.mapper.CreditCardInfoMapper;
import com.credit.mapper.CreditCardSecurityInfoMapper;
import com.credit.pojo.TbCreditCardInfo;
import com.credit.pojo.TbCreditCardSecurityInfo;
import com.credit.service.ClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {

    @Resource
    private CreditCardSecurityInfoMapper creditCardSecurityInfoMapper;

    @Resource
    private CreditCardInfoMapper creditCardInfoMapper;

    /**
     * 查找用户下的所有卡号(用户安全信息表)
     * @param uid
     * @return
     */
    @Override
    public List<TbCreditCardSecurityInfo> findCardidlistbyUid(Long uid) {
        TbCreditCardSecurityInfo vo = new TbCreditCardSecurityInfo();
        vo.setUid(uid);
        return creditCardSecurityInfoMapper.select(vo);
    }

    /**
     * 通过卡号ccid查找卡片信息（信用卡信息表）
     * @param ccId
     * @return
     */
    @Override
    public TbCreditCardInfo findCardInfobyCcid(Long ccId) {
        TbCreditCardInfo vo = new TbCreditCardInfo();
        vo.setCcId(ccId);
        return creditCardInfoMapper.selectOne(vo);
    }

    /**
     * 查询所有信用卡
     * @return List<TbCreditCardInfo>
     */
    public List<TbCreditCardInfo> findallTbCreditCardInfo(){
        return creditCardInfoMapper.selectAll();
    }

    /**
     * 更新信用卡的账单日、还款日等
     * @param vo TbCreditCardInfo对象
     * @return
     */
    public boolean updateBillDateAndRepayDate(TbCreditCardInfo vo){
        int i = creditCardInfoMapper.updateByPrimaryKeySelective(vo);
        return i > 0 ? true : false;
    }
}
