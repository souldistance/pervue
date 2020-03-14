package com.songyinglong.pervue.controller;

import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.service.IPromotionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Souldistance
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @Resource
    private IPromotionService iPromotionService;
    
    /**
    * @Description 促销全查,为了复选框
    * @Param       []
    * @Date        2020/3/13
    * @Time        21:07
    */
    @RequestMapping("listAll")
    public Result list() {
        return Result.ok(iPromotionService.list());
    }
}
