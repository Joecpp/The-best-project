package com.halley.controller;

import com.halley.bean.Field;
import com.halley.bean.Payment;
import com.halley.bean.PaymentForJson;
import com.halley.bean.Response;
import com.halley.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/7/23 12:22
 */
@Controller
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    @ResponseBody
    public Response getPayment(@RequestBody Field field){
        Response response;
        response = paymentService.paymentCal(field.getDeptName(), field.getDate());

        return response;
    }
}
