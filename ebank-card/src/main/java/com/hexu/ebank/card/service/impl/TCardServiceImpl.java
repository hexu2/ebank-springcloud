package com.hexu.ebank.card.service.impl;

import com.hexu.ebank.card.entity.warpper.TAmountWarpper;
import com.hexu.ebank.card.entity.warpper.TCardWarpper;
import com.hexu.ebank.card.mapper.TAmountMapper;
import com.hexu.ebank.card.mapper.TCardMapper;
import com.hexu.ebank.card.service.TCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TCardServiceImpl implements TCardService {
    private static final Logger logger = LoggerFactory.getLogger(TCardServiceImpl.class);
    private static final String classname = TCardServiceImpl.class.getName();

    @Autowired
    private TCardMapper tCardMapper;

    @Autowired
    private TAmountMapper tAmountMapper;

    @Override
    public List<TCardWarpper> selectAllTCardWarpper() {
        return tCardMapper.selectAllTCardWarpper();
    }

    @Override
    public List<TCardWarpper> selectAllTCardWarpperByUserId(Integer userId) {
        List<TCardWarpper> cardlist = null;
        List<TCardWarpper> cardlistReturn = null;
        try{

            cardlist = tCardMapper.selectAllTCardWarpperByUserId(userId);
            if(cardlist != null && cardlist.size() >0){
                cardlistReturn = new ArrayList<>();
                TCardWarpper tCardWarpper = null;
                for(int i = 0; i < cardlist.size(); i++){
                    tCardWarpper = cardlist.get(i);
                    if(tCardWarpper != null){
                        Integer cardId = tCardWarpper.getId();
                        List<TAmountWarpper> tAmountWarpperList = tAmountMapper.selectTamountWarpperByCardId(cardId);
                        tCardWarpper.setAmounts(tAmountWarpperList);
                        cardlistReturn.add(tCardWarpper);
                    }
                }

            }
        } catch (Exception e){
            logger.error(classname + "selectAllTCardWarpperByUserId() : {}" + e);
        }
        return cardlistReturn;
    }

    /**
     * get card details by card id
     * @param cardId
     * @return
     */
    @Override
    public TCardWarpper getCardDetailsByCardId(Integer cardId) {
        TCardWarpper tCardWarpper = null;
        List<TAmountWarpper> tAmountWarpperList = null;
        try{
            tCardWarpper = tCardMapper.getCardDetailsByCardId(cardId);
            tAmountWarpperList = tAmountMapper.selectTamountWarpperByCardId(cardId);
            tCardWarpper.setAmounts(tAmountWarpperList);
        }catch (Exception e){
            logger.error(classname + "getCardDetailsByCardId() : {}" + e);
        }
        return tCardWarpper;
    }
}
