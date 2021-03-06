package com.hexu.ebank.card.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TAmount {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_amount.id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_amount.card_id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    private Integer cardId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_amount.currency_id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    private Integer currencyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_amount.amount_value
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    private Double amountValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_amount.amount_type_id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    private Integer amountTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_amount.create_time
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_amount.update_time
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_amount.id
     *
     * @return the value of t_amount.id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_amount.id
     *
     * @param id the value for t_amount.id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_amount.card_id
     *
     * @return the value of t_amount.card_id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public Integer getCardId() {
        return cardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_amount.card_id
     *
     * @param cardId the value for t_amount.card_id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_amount.currency_id
     *
     * @return the value of t_amount.currency_id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public Integer getCurrencyId() {
        return currencyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_amount.currency_id
     *
     * @param currencyId the value for t_amount.currency_id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_amount.amount_value
     *
     * @return the value of t_amount.amount_value
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public Double getAmountValue() {
        return amountValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_amount.amount_value
     *
     * @param amountValue the value for t_amount.amount_value
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public void setAmountValue(Double amountValue) {
        this.amountValue = amountValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_amount.amount_type_id
     *
     * @return the value of t_amount.amount_type_id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public Integer getAmountTypeId() {
        return amountTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_amount.amount_type_id
     *
     * @param amountTypeId the value for t_amount.amount_type_id
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public void setAmountTypeId(Integer amountTypeId) {
        this.amountTypeId = amountTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_amount.create_time
     *
     * @return the value of t_amount.create_time
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_amount.create_time
     *
     * @param createTime the value for t_amount.create_time
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_amount.update_time
     *
     * @return the value of t_amount.update_time
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_amount.update_time
     *
     * @param updateTime the value for t_amount.update_time
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}