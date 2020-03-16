package com.songyinglong.pervue.controller;


import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.service.ITypeService;
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
 * @since 2020-03-15
 */
@RestController
@RequestMapping("/type")
public class TypeController {

    @Resource
    private ITypeService typeService;

    @RequestMapping("/types")
    public Result types(){
        return Result.ok(typeService.list());
    }
}
