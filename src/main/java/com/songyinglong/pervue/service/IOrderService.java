package com.songyinglong.pervue.service;

import com.songyinglong.pervue.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-08
 */
public interface IOrderService extends IService<Order> {

    List<Order> selectVO(Order order);

    boolean addOrder(Order order);
}
