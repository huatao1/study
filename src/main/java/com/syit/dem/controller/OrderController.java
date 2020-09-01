package com.syit.dem.controller;


import com.syit.dem.entity.OrderInvoice;
import com.syit.dem.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {
    private Logger log = LoggerFactory.getLogger(getClass());


    @Resource
    public OrderService   orderService;
    @RequestMapping(value = "/getOrderInvoicelist")
    public void getOrderInvoiceList(){
        List<OrderInvoice>  OrderInvoiceList=null;
        try{
            OrderInvoiceList=orderService.getOrderInvoiceList();
        }catch (Exception e){
            log.info("--------出错----------");
        }
    }
}
