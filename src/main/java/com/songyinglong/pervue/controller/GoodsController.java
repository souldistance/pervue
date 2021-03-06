package com.songyinglong.pervue.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.Goods;
import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.entity.User;
import com.songyinglong.pervue.entity.UserVO;
import com.songyinglong.pervue.service.IGoodsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private IGoodsService iGoodsService;

    @RequestMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") long current,
                       @RequestParam(defaultValue = "10") long size){
        Page<Goods> page = new Page<>(current,size);
        //自定义查询分页实现
        IPage<Goods> pageInfo = iGoodsService.page(page);

        return Result.ok(pageInfo);
    }

    @RequestMapping("/goodsList")
    public Result goodsList(){
        return Result.ok(iGoodsService.list());
    }

    /**
     * @Description 商品添加
     * @Param [goods]
     * @Return com.caoyuan.xiao4.pervue.vo.Result
     * @Author Mr.Cao
     * @Date 2020/3/8
     * @Time 11:39
     */
    @RequestMapping("insertOrupdate")
    public Result insert(@RequestBody Goods goods) {
        System.err.println(goods+"==========");
        return Result.ok(iGoodsService.save(goods));
    }
}
