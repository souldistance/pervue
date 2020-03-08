package com.songyinglong.pervue.controller;


import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.service.INationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 城市字典表 前端控制器
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/nation")
public class NationController {

    @Resource
    private INationService iNationService;

    @RequestMapping("/list")
    public Result findAll(){
        return  Result.ok(iNationService.findAll());
    }
}