package com.songyinglong.pervue.controller;


import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/list")
    public Result list(){
        return Result.ok(iRoleService.list());
    }
}
