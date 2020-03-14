package com.songyinglong.pervue.service.impl;

import com.songyinglong.pervue.entity.Goods;
import com.songyinglong.pervue.entity.Order;
import com.songyinglong.pervue.entity.OrderItem;
import com.songyinglong.pervue.mapper.OrderItemMapper;
import com.songyinglong.pervue.mapper.OrderMapper;
import com.songyinglong.pervue.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-08
 */
@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public List<Order> selectVO(Order order) {
        return orderMapper.selectVO(order);
    }

    @Override
    public boolean addOrder(Order order) {
        order.setOrderSn("100"+UUID.randomUUID());
        BigDecimal totalPrice=new BigDecimal(0);
        for (Goods good : order.getGoods()) {
            totalPrice=totalPrice.add(good.getPrice());
        }
        order.setTotalPrice(totalPrice);
        order.setUserId(1);
        int insert = orderMapper.insert(order);
        for (Goods good : order.getGoods()) {
            OrderItem orderItem = new OrderItem();
            //放入订单和商品id
            orderItem.setOid(order.getId());
            orderItem.setGid(good.getId());
            //默认数量1个
            orderItem.setAmount(1);
            orderItem.setPrice(good.getPrice());
            orderItemMapper.insert(orderItem);
        }
        return insert > 0;
    }
}
