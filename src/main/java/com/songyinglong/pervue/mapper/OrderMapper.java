package com.songyinglong.pervue.mapper;

import com.songyinglong.pervue.entity.Goods;
import com.songyinglong.pervue.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-08
 */
public interface OrderMapper extends BaseMapper<Order> {

    List<Order> selectVO(Order order);

    List<Goods> selectGoods(Integer id);
}
