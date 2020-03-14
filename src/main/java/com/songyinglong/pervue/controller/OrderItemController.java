package com.songyinglong.pervue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.songyinglong.pervue.entity.OrderItem;
import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.service.IOrderItemService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-08
 */
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Resource
    private IOrderItemService iOrderItemService;

    /**
     * @Description 查看订单详情 根据订单id,查看详情列表
     * @Param       [id]
     * @Author      Mr.Cao
     * @Date        2020/3/8
     * @Time        12:52
     */
    @RequestMapping("list")
    public Result list(Integer id) {
        QueryWrapper<OrderItem> wrapper = new QueryWrapper<>();
        wrapper.eq("oid", id);
        return Result.ok(iOrderItemService.list(wrapper));
    }

}
