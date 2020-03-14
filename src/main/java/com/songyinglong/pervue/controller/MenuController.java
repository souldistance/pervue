package com.songyinglong.pervue.controller;


import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.service.IMenuService;
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
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private IMenuService menuService;

    @RequestMapping("queryAll")
    public Result queryAll(){
        return Result.ok(menuService.listMenus());
    }
}
