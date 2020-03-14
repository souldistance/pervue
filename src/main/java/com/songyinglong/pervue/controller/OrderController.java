package com.songyinglong.pervue.controller;


import com.songyinglong.pervue.entity.Order;
import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.service.IOrderService;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IOrderService iOrderService;

    /**
     * @Description 订单列表,需要三表多对多
     * @Param       [order]
     * @Return      com.caoyuan.xiao4.pervue.vo.Result
     * @Author      Mr.Cao
     * @Date        2020/3/8
     * @Time        11:54
     */
    @RequestMapping("list")
    public Result list(Order order) {
        return Result.ok(iOrderService.selectVO(order));
    }

    /**
     * @Description 添加订单,同时添加中间表
     * @Param       [order]
     * @Return      com.caoyuan.xiao4.pervue.vo.Result
     * @Author      Mr.Cao
     * @Date        2020/3/8
     * @Time        12:29
     */
    @RequestMapping("insert")
    public Result insert(@RequestBody Order order) {
        return Result.ok(iOrderService.addOrder(order));
    }
}

