package com.syit.dem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syit.dem.Mapper.OrderMapper;
import com.syit.dem.Mapper.StudentMapper;
import com.syit.dem.entity.OrderInvoice;
import com.syit.dem.entity.Student;
import com.syit.dem.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private  OrderMapper orderMapper;

    @Resource
    private StudentMapper  studentMapper;
    @Override
    public List<OrderInvoice> getOrderInvoiceList() {
        QueryWrapper<OrderInvoice> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id","YNC5B0U8ADU1009F420UU");

        QueryWrapper<Student> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("id","1");
//        List<Student> studentLists= studentMapper.selectList(wrapper2);
//        System.out.println(studentLists.size());
        return orderMapper.selectList(wrapper);
    }
}
