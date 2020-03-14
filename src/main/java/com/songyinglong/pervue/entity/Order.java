package com.songyinglong.pervue.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 下单人
     */
    private Integer userId;

    /**
     * 总金额
     */
    private BigDecimal totalPrice;

    /**
     * 订单状态
1-已下单待支付
2-已支付待发货
3-已发货待收货
4-已收货待评价

     */
    private Integer status;

    /**
     * 下单时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date created;


    /**
     * @Description 一个订单对应多个商品,写入map映射.
     * @Param
     * @Return
     * @Author      Mr.Cao
     * @Date        2020/3/8
     * @Time        11:56
     */
    @TableField(exist = false)//本注释只针对于plus自带的方法,自己创建的方法不识别这个
    private List<Goods> goods;
}
