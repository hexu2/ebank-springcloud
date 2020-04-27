package com.hexu.ebank.card.service;

import com.hexu.ebank.card.entity.warpper.TAmountWarpper;

import java.util.List;

public interface TAmountService {

    List<TAmountWarpper> selectAllTamountWarpper();

    List<TAmountWarpper> selectTamountWarpperByCardId(Integer cardId);


}
