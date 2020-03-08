package com.songyinglong.pervue.service.impl;

import com.songyinglong.pervue.entity.Order;
import com.songyinglong.pervue.mapper.OrderMapper;
import com.songyinglong.pervue.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
