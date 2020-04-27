package com.hexu.ebank.card.service.impl;

import com.hexu.ebank.card.entity.warpper.TAmountWarpper;
import com.hexu.ebank.card.mapper.TAmountMapper;
import com.hexu.ebank.card.service.TAmountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TAmountServiceImpl implements TAmountService {



    private static final Logger logger = LoggerFactory.getLogger(TAmountServiceImpl.class);
    private static final String classname = TAmountServiceImpl.class.getName();

    @Autowired
    private TAmountMapper tAmountMapper;


    /**
     * Select All amount
     * @return
     */
    public List<TAmountWarpper> selectAllTamountWarpper() {
        return tAmountMapper.selectAllTamountWarpper();
    }

    /**
     * select amunt list by card id
     * @param cardId
     * @return
     */
    public List<TAmountWarpper> selectTamountWarpperByCardId(Integer cardId) {
        return tAmountMapper.selectTamountWarpperByCardId(cardId);
    }
}
