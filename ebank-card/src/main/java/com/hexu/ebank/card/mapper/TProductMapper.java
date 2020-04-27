package com.hexu.ebank.card.mapper;

import com.hexu.ebank.card.entity.TProduct;
import java.util.List;

public interface TProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    int insert(TProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    TProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    List<TProduct> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product
     *
     * @mbg.generated Sat Dec 28 23:19:59 CST 2019
     */
    int updateByPrimaryKey(TProduct record);
}