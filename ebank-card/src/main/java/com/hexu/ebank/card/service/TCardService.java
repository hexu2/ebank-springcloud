package com.hexu.ebank.card.service;

import com.hexu.ebank.card.entity.warpper.TCardWarpper;

import java.util.List;

public interface TCardService {


    /**
     * select all TCardWarpper
     * @return
     */
    List<TCardWarpper> selectAllTCardWarpper();

    /**
     * select all TCardWarpper by userId
     * @param userId
     * @return
     */
    List<TCardWarpper> selectAllTCardWarpperByUserId(Integer userId);

    TCardWarpper getCardDetailsByCardId(Integer cardId);
}
