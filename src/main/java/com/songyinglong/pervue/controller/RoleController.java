package com.songyinglong.pervue.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.entity.Role;
import com.songyinglong.pervue.entity.User;
import com.songyinglong.pervue.entity.UserVO;
import com.songyinglong.pervue.service.IMenuRoleService;
import com.songyinglong.pervue.service.IRoleService;
import com.songyinglong.pervue.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Arrays;

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

    @Resource
    private IRoleService iRoleService;

    @Resource
    private IMenuRoleService iMenuRoleService;

    @RequestMapping("/queryAll")
    public Result queryAll(){
        return Result.ok(iRoleService.list());
    }

    @RequestMapping("/list")
    public Result list(RoleVO roleVO, @RequestParam(defaultValue = "1") long current,
                       @RequestParam(defaultValue = "3") long size){
        Page<RoleVO> page = new Page<>(current,size);
        //自定义查询分页实现
        IPage<RoleVO> pageInfo = iRoleService.selectPageVo(page, roleVO);

        return Result.ok(pageInfo);
    }

    @RequestMapping("/delete")
    public Result delete(Integer []ids) {

        boolean result=iRoleService.deleteRoles(ids);
        return Result.ok(result);
    }

    @RequestMapping("insertOrUpdate")
    public Result insertOrUpdate(@RequestBody Role role) {

        boolean result=iRoleService.saveOrUpdate(role);
        return Result.ok(result);
    }

}
