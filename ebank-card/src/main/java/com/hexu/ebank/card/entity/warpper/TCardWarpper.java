package com.hexu.ebank.card.entity.warpper;

import com.hexu.ebank.card.entity.TCard;
import lombok.Data;

import java.util.List;

@Data
public class TCardWarpper extends TCard {

    List<TAmountWarpper> amounts;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_card_type.card_type_name
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    private String cardTypeName;


    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.product_type_name
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    private String productTypeName;

}
