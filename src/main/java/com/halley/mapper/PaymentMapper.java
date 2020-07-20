package com.halley.mapper;

import com.halley.bean.Payment;
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
}
