package com.syit.dem.Mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syit.dem.entity.OrderInvoice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OrderMapper   extends BaseMapper<OrderInvoice> {



}
