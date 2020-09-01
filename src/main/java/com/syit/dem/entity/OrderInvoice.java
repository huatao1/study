package com.syit.dem.entity;

import com.baomidou.mybatisplus.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@TableName("order_invoice")
public class OrderInvoice  implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(
            value = "id",
            type = IdType.AUTO
    )
    private Long id;
    @TableField(value = "order_id")
    private String orderId;
    private String invoice_id;
    private String user_id;
    private Integer electronic;
    private BigDecimal invoice_amount;
    private Integer invoice;
    private Integer invoice_type;
    private String invoice_title;
    private Integer invoice_project;
    private String invoice_remark;
    private String send_cellphone;
    private String send_name;
    private String send_address;
    private String customer_identifier;
    private String status;
    private String create_operator;
    private Date create_time;
    private String invoice_operator;
    private Date invoice_time;
    private String confirm_operator;
    private Date confirm_time;
    private String express_operator;
    private Date express_time;
    private String invoice_no;
    private String fail_msg;
    private String send_email;
    private String img_url;
    private String pdf_url;
    private String express;
    private String express_no;
    private String serial_no;
    private Integer payee;
    private Date update_time;
    private String distributor_invoice_id;
    private String distributor_red_invoice_id;
    private String post_status;
    private Integer third_party;



}
