package com.songyinglong.pervue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.songyinglong.pervue.entity.Result;
import com.songyinglong.pervue.entity.UserRole;
import com.songyinglong.pervue.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songyinglong
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Resource
    private IUserRoleService userRoleService;

    @RequestMapping("/insert")
    public Result insert(Integer uid,  Integer []rids){
        System.out.println(rids);
        //先删除
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid",uid);
        userRoleService.remove(queryWrapper);
        //在执行保存
        if(rids!=null&&rids.length>0){
            //创建批量保存的集合
            List<UserRole> entityList = new ArrayList<>();
            //for循环遍历角色的id
            for(Integer rid:rids){
                //创建用户角色对象
                UserRole user_role = new UserRole();
                //设置用户的id值
                user_role.setUid(uid);
                //设置用户的角色id值
                user_role.setRid(rid);
                //加入到集合中
                entityList.add(user_role);
            }
            userRoleService.saveBatch(entityList);
        }
        //返回结果
        return Result.ok(true);
    }
}
