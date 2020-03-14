package com.songyinglong.pervue.controller;


import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/menuRole")
public class MenuRoleController {

    @Resource
    private IMenuRoleService menuRoleService;

    @RequestMapping("/insert")
    public Result insert(Integer rid,Integer mids[]){
        try {
            menuRoleService.insertBatch(rid,mids);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.ok(false);
        }
        return Result.ok(true);
    }
}
