package com.halley.mapper;

import com.halley.bean.Item;
import com.halley.bean.ItemRec;
import com.halley.bean.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/20 20:26
 */
@Repository
public interface PaymentMapper {
    /**
     * 获取所有实发项目
     * @return
     */
    List<Payment> getAllPayment();

    /**
     * 根据项目名查询实发项目
     * @param ItemName
     * @return
     */
    Payment getPaymentByItemName(String ItemName);

    /**
     *  插入项目
     * @param itemRec
     */
    void insertItemRec(ItemRec itemRec);

    /**
     * 获取项目
     * @param empNo
     * @param itemNo
     * @param year
     * @param month
     * @return
     */
    ItemRec selectItemRec(Integer empNo,Integer itemNo,String year, String month);

    /**
     * 插入所有工资项目
     * @param payment
     */
    void insertPayment(Payment payment);

    /**
     * 获得payment by主键
     * @param empNo
     * @param year
     * @param month
     * @return
     */
    Payment selectPaymentByKey(Integer empNo,String year,String month);
}
